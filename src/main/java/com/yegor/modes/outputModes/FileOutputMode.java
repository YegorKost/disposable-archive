package com.yegor.modes.outputModes;

import com.yegor.interfaces.LibMode;
import com.yegor.interfaces.OutputMode;

import java.io.*;

/**
 * This class defines a mode of <code>output</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(InputStream, OutputStream, String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(InputStream, OutputStream, String)}</code> methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class FileOutputMode implements OutputMode {

    private OutputStream output;
    private File file;

    /**
    * This method initializes the OutputStream object for
    * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code> or
    * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code> methods.
    * @param output a archive file where data will be packed or a directory where data will be unpacked
    */
    @Override
    public void setOutputMode(String output) {
        file = new File(output);
    }

    /**
     * This method returns OutputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code> or
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code> methods.
     * @return the OutputStream object for pack or unpack modes
     */
    @Override
    public OutputStream getOutput() {
        try {
            this.output = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }

    /** This method return File object that represents directory for unpackArchive method */
    public File getFile() {
       return file;
    }
}
