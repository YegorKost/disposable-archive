package com.yegor.modes.inputModes;

import com.yegor.interfaces.InputMode;
import com.yegor.interfaces.LibMode;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * This class defines a mode of <code>input</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(InputStream, OutputStream, String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(InputStream, OutputStream, String)}</code>
 * methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class FileInputMode implements InputMode{

    private InputStream input;

    /**
     * This method initialize the InputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code> or
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code> methods.
     * @param input file or directory that will be packed or archive file that will be unpacked
     */
    @Override
    public void setInputMode(String input) {
        this.input = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * This method returns InputStream object for
     * <code>{@link LibMode#packArchive(InputStream, OutputStream, String)}</code> or
     * <code>{@link LibMode#unpackArchive(InputStream, OutputStream, String)}</code> methods.
     * @return the InputStream object for pack or unpack modes
     */
    @Override
    public InputStream getInput() {
        return input;
    }

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   