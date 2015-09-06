package actionWithArchive;

import interfases.TypeOfArchive;

import java.io.File;

/**
 * A class sets mode of archive.
 *
 * @author YegorKostochka
 * @version 1.0
 */
public abstract class Archive {

    private TypeOfArchive typeOfArchive;

    /**
     * Sets mode of archive
     * @param typeOfArchive mode of archive
     */
    public void setTypeOfArchive(TypeOfArchive typeOfArchive) {
        this.typeOfArchive = typeOfArchive;
    }

    public TypeOfArchive getTypeOfArchive() {
        return typeOfArchive;
    }

    /**
     * Creates archive file with password and than stores it to assigned path
     * @param file the file or directory will be written
     * @param pathToArchive path where archive file will be store
     */
    abstract void createArchive (String file, String pathToArchive);

    /**
     * Extracts contents from archive file
     * @param file the archive file
     * @param pathToFile path where extracting contents will be store
     */
    abstract void extractFromArchive (String file, String pathToFile);

}
