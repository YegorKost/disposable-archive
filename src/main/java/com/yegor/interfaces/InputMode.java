package com.yegor.interfaces;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.String;

/**
 * A class that implements this interface defines a mode of <code>input</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(InputStream, OutputStream, String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(InputStream, OutputStream, String)}</code>
 * methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface InputMode {

    /**
     * This method initializes the InputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code> or
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code> methods.
     * @param input data that will be packed or unpacked
     */
    void setInputMode(String input);

    /**
     * This method returns InputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code> or
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code> methods.
     * @return the InputStream object for pack or unpack modes
     */
    InputStream getInput();

}
