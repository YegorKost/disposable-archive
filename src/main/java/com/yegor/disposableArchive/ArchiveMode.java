package com.yegor.disposableArchive;

import com.yegor.interfaces.*;

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
    private ProgramMode programMode;
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

    public ProgramMode getProgramMode() {
        return programMode;
    }

    public void setProgramMode(ProgramMode programMode) {
        this.programMode = programMode;
    }

    public static ArchiveMode getArchiveMode() {
        return archiveMode == null ? archiveMode = new ArchiveMode(): archiveMode;
    }

    public boolean isInitialized () {
        assert archiveMode !=null;
        return (libMode != null) && (inputMode != null) && (outputMode != null) && (passwordMode != null);
    }
}
