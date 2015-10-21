package com.yegor.modes.libModes;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.modes.inputModes.FileInputMode;
import com.yegor.modes.outputModes.FileOutputMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertTrue;

/**
 * Created by Администратор on 21.09.2015.
 */
public class LibZip4jTest1 {
    InputStream inputStreamForPack;
    OutputStream outputStreamForPack;
    InputStream inputStreamForUnpack;
    OutputStream outputStreamForUnpack;
    File testedDirectory;
    File dirs;
    File emptyDir;
    File tempFile;
    File zipFile;
    File outDir;
    LibZip4j libZip4j;

    @Before
    public void setUp() throws Exception {

        testedDirectory = new File("/Tested Directory");
        dirs = new File(testedDirectory, File.separator + "1" + File.separator + "2");
        emptyDir = new File(dirs.getParentFile(), File.separator + "empty");
        zipFile = new File(testedDirectory, "/test.zip");
        outDir = new File(testedDirectory, "/Test");

        if (testedDirectory.mkdir()) {
            System.out.println("Directory " + testedDirectory.getPath() + " is created");
            if (dirs.mkdirs() && emptyDir.mkdirs()){
                System.out.println("Directories " + dirs.getPath() + " and " + emptyDir.getPath() + " are created");
                tempFile = File.createTempFile("test", null, dirs);

                if (tempFile.exists()){

                    System.out.println("Temp file " + tempFile.getName() + " is created");
                    ArchiveMode archiveModePack = ArchiveMode.getArchiveMode();
                    archiveModePack.setInputMode(new FileInputMode());
                    String input = tempFile.getParentFile().getParentFile().getCanonicalPath();
                    inputStreamForPack = archiveModePack.getInputMode().setInputMode(input);
                    archiveModePack.setOutputMode(new FileOutputMode());
                    outputStreamForPack = archiveModePack.getOutputMode().setOutputMode(zipFile.getCanonicalPath());

                    if (outDir.mkdirs()) {
                        ArchiveMode archiveModeUnpack = ArchiveMode.getArchiveMode();
                        archiveModeUnpack.setInputMode(new FileInputMode());
                        inputStreamForUnpack = archiveModeUnpack.getInputMode().setInputMode(zipFile.getCanonicalPath());
                        archiveModeUnpack.setOutputMode(new FileOutputMode());
                        outputStreamForUnpack = archiveModeUnpack.getOutputMode().setOutputMode(outDir.getCanonicalPath());
                    } else {
                        System.out.println("Directory " + outDir + "is not created");
                    }

                } else {
                    System.out.println("Temp file " + tempFile.getName() + " is not exist");
                }

            } else {
                System.out.println("Directories " + dirs.getPath() + " and " + emptyDir.getPath() + " are not created");
            }
        }



    }

    @After
    public void tearDown() throws Exception {

        if (outputStreamForPack != null) {
            try{
                outputStreamForPack.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStreamForPack != null) {
            try{
                inputStreamForPack.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputStreamForUnpack != null) {
            try{
                outputStreamForUnpack.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStreamForUnpack != null) {
            try{
                inputStreamForUnpack.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        deleteAll(testedDirectory);

    }

    @Test
    public void testPackUnpackArchive() throws Exception {

        libZip4j = new LibZip4j();
        libZip4j.packArchive(inputStreamForPack, outputStreamForPack, "123");
        assertTrue(zipFile.exists());
        libZip4j.unpackArchive(inputStreamForUnpack, outputStreamForUnpack, "123");




    }

    private void deleteAll(File file) {
        File [] files;
        if (file.isDirectory() && (files = file.listFiles()) != null && files.length != 0) {
            for (File file1: files) {
                deleteAll(file1);
            }
            if (file.delete()) {
                System.out.println(file.getPath() + " is deleted");
            }
        } else {
            if (file.delete()) {
                System.out.println(file.getPath() + " is deleted");
            }
        }
    }
}