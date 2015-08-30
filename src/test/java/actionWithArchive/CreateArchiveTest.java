package actionWithArchive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Администратор on 29.08.2015.
 */
public class CreateArchiveTest {
    File currentDir;
    File fileToZip;
    String zipName;

    @Before
    public void setUp() throws Exception {
        currentDir = new File(".");
        fileToZip = new File(currentDir, "testDir" + File.separator + "test.txt");
        zipName = currentDir.getCanonicalPath()+ File.separator + "test.zip";
    }

    @Test
    public void testCreateArchive() throws Exception {

        CreateArchive archive = new CreateArchive();
        if (fileToZip.getParentFile().mkdir() && fileToZip.createNewFile()) {
            archive.createArchive(fileToZip, zipName);
            assertTrue("File " + zipName + " is not exist", new File(zipName).exists());
        } else {
            System.out.println("File " + fileToZip.getCanonicalPath() + "\t" + "not exist");
        }

    }

    @After
    public void tearDown() throws Exception {
        if (new File(zipName).delete()) {
            System.out.println("The tested archive file is deleted successful!");
        }
        if (fileToZip.delete()) {
            System.out.println("The tested file is deleted successful!");
        }
        if (fileToZip.getParentFile().delete()) {
            System.out.println("The tested directory is deleted successful!");
        }
    }
}