package typesOfArchive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * A class tests methods of LibZip4j class
 */
public class LibZip4jTest {
    File file;
    File zipFile;
    File unZipDir;

    @Before
    public void setUp() throws Exception {

        file = new File("Test" + File.separator + "test.txt");
        if (file.getParentFile().mkdir())
            System.out.println("Test directory is created");
        if (file.createNewFile())
            System.out.println("test.txt is created");

        zipFile = new File("zipTest.zip");

        unZipDir = new File("UnZipDir");
        if (unZipDir.mkdir())
            System.out.println("UnZipDir directory is created");

        // Write hashcode of tested file to it
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)){
            fileOutputStream.write(file.hashCode());
        }

    }

    @After
    public void tearDown() throws Exception {

        if (unZipDir.delete())
            System.out.println("Directory UnZipDir is deleted");

        if (zipFile.delete())
            System.out.println("zipTest.zip is deleted");

        if (file.delete())
            System.out.println("test.txt is deleted");

        if (file.getParentFile().delete())
            System.out.println("Directory Test is deleted");


    }

    @Test
    public void libZip4jTest() throws Exception {
        LibZip4j libZip4j = new LibZip4j();
        libZip4j.packArchive(file, zipFile, "123");
        libZip4j.unpackArchive(zipFile, unZipDir, "123");
        System.out.println("UnZipDir has unpacked file(s) " + Arrays.toString(unZipDir.list()));
        for (File f: unZipDir.listFiles()){
            // Check if hashcode written to the tested file equals to hashcode written to unpack file
            try (FileInputStream fileInputStream1 = new FileInputStream(f);
                 FileInputStream fileInputStream2 = new FileInputStream(file)) {
                int i1, i2;
                     while ((i1 = fileInputStream1.read()) != -1 & (i2 = fileInputStream2.read()) != -1){
                         assertTrue(i1 == i2);
                         System.out.println(f.getAbsolutePath() + "; written hashcode: " + i1 + " equals to " + "\n" +
                         file.getAbsolutePath() + "; written hashcode: " + i2);
                     }
                 }
            if (f.delete())
                System.out.println(f.getPath() + " is deleted");
        }

    }

}