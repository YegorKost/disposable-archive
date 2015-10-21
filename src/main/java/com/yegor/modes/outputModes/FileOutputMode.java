package com.yegor.modes.outputModes;

import com.yegor.interfaces.LibMode;
import com.yegor.interfaces.OutputMode;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class defines a mode of <code>output</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class FileOutputMode implements OutputMode {
    /**
     * @return the OutputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code>
     * method
     */
    @Override
    public OutputStream setOutputModeForPack() {
        return null;
    }

    /**
     * @return the OutputStream object for
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code>
     * method
     */
    @Override
    public OutputStream setOutputModeForUnpack() {
        return null;
    }
}
