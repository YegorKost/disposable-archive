package typesOfArchive;

import actionWithArchive.AllFiles;
import interfases.TypeOfArchive;
import java.io.File;
import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.IOException;
import java.util.ArrayList;

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
        // List that store archived files
        ArrayList<File> filesToArchive;

        try {
            // Initiate ZipFile object with the File object
            ZipFile zipFile = new ZipFile(pathToArchive);
            // Add files to the list
            filesToArchive = new AllFiles().getFiles(file);
            // Initiate zip parameters
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            // Set the encryption flag to true
            zipParameters.setEncryptFiles(true);
            zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
            zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
            zipParameters.setPassword(psw.toCharArray());
            // Add files to the zip file
            zipFile.addFiles(filesToArchive, zipParameters);

        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param file       the archive file
     * @param pathToFile path where extracting contents will be store
     * @param psw        password of archive
     */
    @Override
    public void unpackArchive(File file, File pathToFile, String psw) {

        try {
            // Initiate ZipFile object with the File object
            ZipFile zipFile = new ZipFile(file);
            if (zipFile.isEncrypted()){
                zipFile.setPassword(psw.toCharArray());
            }
            // Extract all files to define destination
            zipFile.extractAll(pathToFile.getCanonicalPath());

        } catch (ZipException | IOException e) {
            e.printStackTrace();
        }

    }
}
