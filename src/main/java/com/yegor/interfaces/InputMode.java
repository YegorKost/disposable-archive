package com.yegor.interfaces;

import java.io.InputStream;

/**
 * A class that implements this interface defines a mode of <code>input</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> methods
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface InputMode {

    /**
     * @return the InputStream object for
     * <code>{@link LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code>
     * method
     */
    InputStream setInputModeForPack ();

    /**
     * @return the InputStream object for
     * <code>{@link LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code>
     * method
     */
    InputStream setInputModeForUnpack ();
}
