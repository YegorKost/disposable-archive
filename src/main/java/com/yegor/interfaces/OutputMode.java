package com.yegor.interfaces;

import java.io.OutputStream;

/**
 * A class that implements this interface defines a mode of <code>output</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface OutputMode {

    /**
     * @return the OutputStream object for
     * <code>{@link LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code>
     * method
     * @param output a target where data will be packed
     */
    OutputStream setOutputModeForPack(String output);

    /**
     * @return the OutputStream object for
     * <code>{@link LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code>
     * method
     * @param output a target where data will be unpacked
     */
    OutputStream setOutputModeForUnpack(String output);
}
