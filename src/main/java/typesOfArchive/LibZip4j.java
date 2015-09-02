package typesOfArchive;

import interfases.TypeOfArchive;

import java.io.File;

/**
 * A class that implements interface TypeOfArchive and uses <i>net.lingala.zip4j</i> library.
 * This class packs files to archive and then unpacks it from archive.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class LibZip4j implements TypeOfArchive {
    /**
     * @param file          the file or directory to be written
     * @param pathToArchive path where archive will be store
     * @param psw           password of archive
     */
    @Override
    public void packArchive(File file, File pathToArchive, String psw) {

    }

    /**
     * @param file       the archive file
     * @param pathToFile path where extracting contents will be store
     * @param psw        password of archive
     */
    @Override
    public void unpackArchive(File file, File pathToFile, String psw) {

    }
}
