package interfases;

import java.io.File;

/**
 * This interface provides method for creation of archive and method for extraction contents of archive
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface TypeOfArchive {

    /**
     * Creates archive file with password and than stores it to assigned path
     * @param file the file or directory to be written
     * @param pathToArchive path where archive will be store
     * @param psw password of archive
     */
    void packArchive (File file, File pathToArchive, String psw);

    /**
     * Extracts contents from archive file
     * @param file the archive file
     * @param pathToFile path where extracting contents will be store
     * @param psw password of archive
     */
    void unpackArchive (File file, File pathToFile, String psw);

}
