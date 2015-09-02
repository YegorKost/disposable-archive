package actionWithArchive;

import interfases.TypeOfArchive;

import java.io.File;

/**
 * A class sets mode of archive.
 *
 * @author YegorKostochka
 * @version 1.0
 */
public class Archive {

    private TypeOfArchive typeOfArchive;

    /**
     * Sets mode of archive
     * @param typeOfArchive mode of archive
     */
    public void setTypeOfArchive(TypeOfArchive typeOfArchive) {
        this.typeOfArchive = typeOfArchive;
    }

    /**
     * Creates archive file with password and than stores it to assigned path
     * @param file the file or directory will be written
     * @param pathToArchive path where archive file will be store
     * @param psw password of archive
     */
    void createArchive (File file, String pathToArchive, String psw) {
        typeOfArchive.packArchive(file, new File(pathToArchive), psw);
    }

    /**
     * Extracts contents from archive file
     * @param file the archive file
     * @param pathToFile path where extracting contents will be store
     * @param psw password of archive
     */
    void extractFromArchive (File file, String pathToFile, String psw){
        typeOfArchive.unpackArchive(file, new File(pathToFile), psw);
    }

}
