package com.yegor.interfaces;

import java.io.OutputStream;
import java.io.InputStream;
import java.lang.String;

/**
 * A class that implements this interface defines a mode of <code>output</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(InputStream, OutputStream, String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(InputStream, OutputStream, String)}</code>
 * methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface OutputMode {

    /**
     * This method initializes the OutputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code> or
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code> methods.
     * @param output a target where data will be packed or unpacked
     */
    void setOutputMode(String output);

    /**
     * This method returns OutputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code> or
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code> methods.
     * @return the OutputStream object for pack or unpack modes
     */
    OutputStream getOutput();

}
