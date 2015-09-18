package com.yegor.initializeMode;

import com.yegor.interfaces.InitializeMode;

/**
 * This class initializes a mode of <code>input</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializeInputMode implements InitializeMode {
    /**
     * This method initializes a mode of  program.
     *
     * @param option specifies a mode of  program
     * @param value  will be initialized for a mode of  program
     */
    @Override
    public void initMode(String option, String value) {

    }
}
