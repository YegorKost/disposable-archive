package com.yegor.initializeMode;

import com.yegor.disposableArchive.ArchiveMode;
import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * This class tests InitializeInputMode class.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializeInputModeTest {

    @Test
    public void testInitMode1() throws Exception {
        InitializeInputMode initInputMode = new InitializeInputMode(null, null);
        initInputMode.initMode();
        org.junit.Assert.assertNull(ArchiveMode.getArchiveMode().getInputMode());
    }

    @Test
    public void testInitMode2() throws Exception {
        InitializeInputMode initInputMode = new InitializeInputMode("wrongOption", "wrongValue");
        initInputMode.initMode();
        org.junit.Assert.assertNull(ArchiveMode.getArchiveMode().getInputMode());

    }

    @Test
    public void testInitMode3() throws Exception {
        InitializeInputMode initInputMode = new InitializeInputMode("if", null);
        initInputMode.initMode();
        org.junit.Assert.assertNull(ArchiveMode.getArchiveMode().getInputMode());

    }

    @Test
    public void testInitMode4() throws Exception {
        InputStream inputStream = null;
        try {
            String trueValue = "trueValue";
            String falseValue = "falseValue";
            InitializeInputMode initInputMode = new InitializeInputMode("if", trueValue);
            initInputMode.initMode();
             inputStream= ArchiveMode.getArchiveMode().getInputMode().getInput();
            byte[] trueValueBytes = trueValue.getBytes(StandardCharsets.UTF_8);
            byte[] falseValueBytes = falseValue.getBytes(StandardCharsets.UTF_8);
            byte[] bytes = new byte[trueValueBytes.length];
            if (inputStream.read(bytes) != -1) {
                System.out.println(Arrays.toString(trueValueBytes) + " = " + Arrays.toString(bytes));
                org.junit.Assert.assertArrayEquals(trueValueBytes, bytes);
                System.out.println(Arrays.toString(falseValueBytes) + " != " + Arrays.toString(bytes));
                org.junit.Assert.assertFalse(Arrays.equals(falseValueBytes, bytes));
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}