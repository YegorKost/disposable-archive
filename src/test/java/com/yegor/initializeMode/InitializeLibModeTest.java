package com.yegor.initializeMode;

import com.yegor.disposableArchive.ArchiveMode;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * This class tests InitializeLibMode class.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializeLibModeTest {

    @Test
    public void testInitMode1() {
        InitializeLibMode initializeLibMode = new InitializeLibMode(null);
        initializeLibMode.initMode();
        assertNull(ArchiveMode.getArchiveMode().getLibMode());
    }

    @Test
    public void testInitMode2() {
        InitializeLibMode initializeLibMode = new InitializeLibMode("wrong value");
        initializeLibMode.initMode();
        assertNull(ArchiveMode.getArchiveMode().getLibMode());
    }

    @Test
    public void testInitMode3() {
        InitializeLibMode initializeLibMode = new InitializeLibMode("zip4j");
        initializeLibMode.initMode();
        assertNotNull(ArchiveMode.getArchiveMode().getLibMode());
    }
}