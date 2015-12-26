package com.yegor.initializeMode;

import com.yegor.disposableArchive.ArchiveMode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests InitializeProgramMode class.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializeProgramModeTest {

    @Test
    public void testInitMode1() throws Exception {
        InitializeProgramMode initializeProgramMode = new InitializeProgramMode(null);
        initializeProgramMode.initMode();
        assertNull(ArchiveMode.getArchiveMode().getProgramMode());
    }

    @Test
    public void testInitMode2() {
        InitializeProgramMode initializeProgramMode = new InitializeProgramMode("wrongOption");
        initializeProgramMode.initMode();
        assertNull(ArchiveMode.getArchiveMode().getProgramMode());
    }

    @Test
    public void TestInitMode3() {
        InitializeProgramMode initializeProgramMode = new InitializeProgramMode("p");
        initializeProgramMode.initMode();
        assertNotNull(ArchiveMode.getArchiveMode().getProgramMode());
    }

    @Test
    public void TestInitMode4() {
        InitializeProgramMode initializeProgramMode = new InitializeProgramMode("unp");
        initializeProgramMode.initMode();
        assertNotNull(ArchiveMode.getArchiveMode().getProgramMode());
    }
}