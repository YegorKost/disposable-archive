package com.yegor.modes.libModes;

import com.yegor.interfaces.LibMode;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * A class that implements interface <code>{@link com.yegor.interfaces.LibMode}</code> and uses
 * <i>net.lingala.zip4j</i> library. This class packs files to archive and then unpacks it from archive.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class LibZip4j implements LibMode {
    /**
     * Creates archive with password and then stores it to assigned target.
     *
     * @param input  the data to be written
     * @param output the target where archive will be store
     * @param psw    password of archive
     */
    @Override
    public void packArchive(InputStream input, OutputStream output, String psw) {

    }

    /**
     * Extracts contents from archive
     *
     * @param input  the archive
     * @param output the target where extracting contents will be store
     * @param psw    password of archive
     */
    @Override
    public void unpackArchive(InputStream input, OutputStream output, String psw) {

    }
//    Beginning of old code

//    /**
//     * @param file          the file or directory to be written
//     * @param pathToArchive path where archive will be store
//     * @param psw           password of archive
//     */
//    @Override
//    public void packArchive(File file, File pathToArchive, String psw) {
//
//        try {
//            //
//            if (!pathToArchive.getParentFile().exists()){
//                if (pathToArchive.getParentFile().mkdirs())
//                    System.out.println("Directory " + pathToArchive.getParentFile() + " is created");
//
//            }
//            // Initiate ZipFile object with the File object
//            ZipFile zipFile = new ZipFile(pathToArchive);
//            // Initiate zip parameters
//            ZipParameters zipParameters = new ZipParameters();
//            zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
//            zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
//            // Set the encryption flag to true
//            zipParameters.setEncryptFiles(true);
//            zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
//            zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
//            zipParameters.setPassword(psw.toCharArray());
//
//            if (file.isDirectory()){
//                zipFile.addFolder(file, zipParameters);
//            } else {
//                zipFile.addFile(file, zipParameters);
//            }
//
//        } catch (ZipException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @param file       the archive file
//     * @param pathToFile path where extracting contents will be store
//     * @param psw        password of archive
//     */
//    @Override
//    public void unpackArchive(File file, File pathToFile, String psw) {
//
//        try {
//            // Initiate ZipFile object with the File object
//            ZipFile zipFile = new ZipFile(file);
//            if (zipFile.isEncrypted()){
//                zipFile.setPassword(psw.toCharArray());
//            }
//            // Extract all files to define destination
//            zipFile.extractAll(pathToFile.getCanonicalPath());
//
//        } catch (ZipException | IOException e) {
//            e.printStackTrace();
//        }
//
//    }

//    Ending of old code
}
