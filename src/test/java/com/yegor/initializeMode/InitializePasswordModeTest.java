package com.yegor.initializeMode;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.interfaces.PasswordMode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * This class tests InitializePasswordMode class.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializePasswordModeTest {

    @Test
    public void testInitMode1() {
        InitializePasswordMode initializePasswordMode = new InitializePasswordMode(null, null);
        initializePasswordMode.initMode();
        assertNull(ArchiveMode.getArchiveMode().getPasswordMode());
    }

    @Test
    public void testInitMode2() {
        InitializePasswordMode initializePasswordMode = new InitializePasswordMode("wrongOption", "wrongValue");
        initializePasswordMode.initMode();
        assertNull(ArchiveMode.getArchiveMode().getPasswordMode());
    }

    @Test
    public void testInitMode3() {
        String password = "123";
        InitializePasswordMode initializePasswordMode = new InitializePasswordMode("pswHC", password);
        initializePasswordMode.initMode();
        PasswordMode passwordMode = ArchiveMode.getArchiveMode().getPasswordMode();
        passwordMode.setSecondPartOfPassword(password);
        assertEquals(password, passwordMode.getPassword());
        assertEquals(Integer.toString(password.hashCode()), passwordMode.getSecondPartOfPassword());
    }
}