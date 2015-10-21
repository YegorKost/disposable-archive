package com.yegor.modes.outputModes;

import com.yegor.interfaces.LibMode;
import com.yegor.interfaces.OutputMode;

import java.io.*;

/**
 * This class defines a mode of <code>output</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class FileOutputMode implements OutputMode {

    private File file;

     /**
     * @return the OutputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code>
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code>
     * methods
     * @param output a file (archive) where data will be packed or a directory where data will be unpacked
     */
    @Override
    public OutputStream setOutputMode(String output) {
        file = new File(output);

        FileOutputStream fileOutputStream = null;
        try {
            if (file.createNewFile()) {

                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileOutputStream;
    }

    /** This method return file object that represents directory for unpackArchive method */
    public File getFile() {
        return file;
    }
}
