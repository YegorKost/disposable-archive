package com.yegor.initializeMode;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.modes.outputModes.FileOutputMode;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * This class tests InitializeOutputMode class.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializeOutputModeTest {

    @Test
    public void testInitMode1() throws Exception {
        InitializeOutputMode initializeOutputMode = new InitializeOutputMode(null, null);
        initializeOutputMode.initMode();
        assertNull(ArchiveMode.getArchiveMode().getOutputMode());
    }

    @Test
    public void testInitMode2() {
        InitializeOutputMode initializeOutputMode = new InitializeOutputMode("wrongOption", "wrongValue");
        initializeOutputMode.initMode();
        assertNull(ArchiveMode.getArchiveMode().getOutputMode());
    }

    @Test
    public void testInitMode3() {
        InitializeOutputMode initializeOutputMode = new InitializeOutputMode("of", null);
        initializeOutputMode.initMode();
        assertNull(ArchiveMode.getArchiveMode().getOutputMode());
    }

    @Test
    public void testInitMode4() {
        OutputStream fileOutputStream = null;

        try {
            File file = File.createTempFile("test", null);
            InitializeOutputMode initializeOutputMode = new InitializeOutputMode("of", file.getPath());
            initializeOutputMode.initMode();
            FileOutputMode fileOutputMode = (FileOutputMode)ArchiveMode.getArchiveMode().getOutputMode();
            File fileActually = fileOutputMode.getFile();
            fileOutputStream = fileOutputMode.getOutput();
            assertEquals(file, fileActually);
            assertEquals(FileOutputStream.class, fileOutputStream.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}