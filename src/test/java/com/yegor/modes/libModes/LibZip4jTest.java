package com.yegor.modes.libModes;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.modes.outputModes.FileOutputMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This class tests LibZip4j class.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
@PrepareForTest({PasswordIntoCache.class, LibZip4j.class, ArchiveMode.class, FileOutputMode.class})
@PowerMockIgnore({"javax.crypto.*"})
@RunWith(PowerMockRunner.class)
public class LibZip4jTest {

    InputStream inputStreamForPack, inputStreamForUnpack;
    OutputStream outputStreamForPack, outputStreamForUnpuck;
    File testedDir, dirToTempFile, dirToEmptyDirectory, tempFile, outDir, zipFile;

    @Before
    public void setUp() throws Exception {

        testedDir = new File(File.separator + "TestedDir");
        dirToTempFile = new File(testedDir + File.separator + "1" + File.separator + "2");
        if (dirToTempFile.mkdirs()) {
            System.out.println(dirToTempFile.getPath() + " is created!");
            dirToEmptyDirectory = new File(dirToTempFile.getParent() + File.separator + "3");
            if (dirToEmptyDirectory.mkdirs()) {
                System.out.println(dirToEmptyDirectory.getPath() + " is created!");
            }
        }

        tempFile = File.createTempFile("test", null, dirToTempFile);

        if (tempFile.exists()) {
            System.out.println("Temporary file " + tempFile.getName() + " is created");
        }


        outDir = new File(testedDir + File.separator + "OutDir");

        zipFile = new File(testedDir, File.separator + "zipFile.zip");



        inputStreamForPack = getInputStream(dirToTempFile.getParentFile());
        inputStreamForUnpack = getInputStream(zipFile);
        outputStreamForPack = getOutputStream(zipFile);
        outputStreamForUnpuck = null;

    }

    @After
    public void tearDown() throws Exception {

        deleteAll(testedDir);

    }

    @Test
    public void testPackUnpackArchive() throws Exception {

        PowerMockito.mockStatic(PasswordIntoCache.class);
        PowerMockito.when(PasswordIntoCache.getPasswordFromCache()).thenReturn("");

        LibZip4j libZip4j = new LibZip4j();
        libZip4j.packArchive(inputStreamForPack, outputStreamForPack, "123");

        ArchiveMode archiveMode = PowerMockito.mock(ArchiveMode.class);
        PowerMockito.whenNew(ArchiveMode.class).withNoArguments().thenReturn(archiveMode);
        FileOutputMode fileOutputMode = PowerMockito.mock(FileOutputMode.class);
        PowerMockito.when(archiveMode.getOutputMode()).thenReturn(fileOutputMode);
        PowerMockito.when(fileOutputMode.getFile()).thenReturn(outDir);

        libZip4j.unpackArchive(inputStreamForUnpack, outputStreamForPack, "123");

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
    private InputStream getInputStream(File file) {
        return new ByteArrayInputStream(file.getPath().getBytes(StandardCharsets.UTF_8));
    }
    private OutputStream getOutputStream(File file) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileOutputStream;
    }

}