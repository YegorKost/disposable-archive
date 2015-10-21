package com.yegor.modes.inputModes;

import com.yegor.interfaces.InputMode;
import com.yegor.interfaces.LibMode;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class defines a mode of <code>input</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class FileInputMode implements InputMode{
    /**
     * @return the InputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code>
     * method
     */
    @Override
    public InputStream setInputModeForPack() {
        return null;
    }

    /**
     * @return the InputStream object for
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code>
     * method
     */
    @Override
    public InputStream setInputModeForUnpack() {
        return null;
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   