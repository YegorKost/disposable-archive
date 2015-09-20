package com.yegor.disposableArchive;

import com.yegor.interfaces.PasswordMode;
import com.yegor.interfaces.InputMode;
import com.yegor.interfaces.OutputMode;
import com.yegor.interfaces.LibMode;

/**
 * A class sets mode of archive.
 *
 * @author YegorKostochka
 * @version 1.0
 */
public class ArchiveMode {

    private LibMode libMode;
    private PasswordMode passwordMode;
    private InputMode inputMode;
    private OutputMode outputMode;
    private static ArchiveMode archiveMode;

    private ArchiveMode(){}

    public LibMode getLibMode() {
        return libMode;
    }

    public void setLibMode(LibMode libMode) {
        this.libMode = libMode;
    }

    public PasswordMode getPasswordMode() {
        return passwordMode;
    }

    public void setPasswordMode(PasswordMode passwordMode) {
        this.passwordMode = passwordMode;
    }

    public InputMode getInputMode() {
        return inputMode;
    }

    public void setInputMode(InputMode inputMode) {
        this.inputMode = inputMode;
    }

    public OutputMode getOutputMode() {
        return outputMode;
    }

    public void setOutputMode(OutputMode outputMode) {
        this.outputMode = outputMode;
    }

    public static ArchiveMode getArchiveMode() {
        return archiveMode == null ? archiveMode = new ArchiveMode(): archiveMode;
    }
}
