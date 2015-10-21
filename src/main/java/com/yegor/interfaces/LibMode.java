package com.yegor.interfaces;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * This interface provides methods for creation of archive and extraction contents from archive.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface LibMode {

    /**
     * Creates archive with password and then stores it to assigned target.
     * @param input the data to be written
     * @param output the target where archive will be store
     * @param psw password of archive
     */
    void packArchive (InputStream input, OutputStream output, String psw);

    /**
     * Extracts contents from archive
     * @param input the archive
     * @param output the target where extracting contents will be store
     * @param psw password of archive
     */
    void unpackArchive (InputStream input, OutputStream output, String psw);

}
