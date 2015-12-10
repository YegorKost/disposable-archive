package com.yegor.modes.libModes;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.interfaces.LibMode;
import com.yegor.modes.outputModes.FileOutputMode;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.unzip.UnzipUtil;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.*;
import java.util.List;


/**
 *
 * A class that implements interface <code>{@link com.yegor.interfaces.LibMode}</code> and uses
 * <i>net.lingala.zip4j</i> library. This class packs files to archive and then unpacks it from archive.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class LibZip4j implements LibMode {

    // This is additional class for creation archive file
    class Parser {

        File getFile(InputStream inputStream) {
            int i;
            StringBuilder sb = new StringBuilder();

            try (BufferedInputStream buffInput = new BufferedInputStream(inputStream)) {

                while ((i = buffInput.read()) != -1){
                    sb.append((char)i);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return new File(sb.toString());
        }

        void zipFile (File file, ZipOutputStream zipOutputStream, ZipParameters parameters) {
            final int BUFF_SIZE = 4096;

            try (InputStream inputStream = new FileInputStream(file)) {
                zipOutputStream.putNextEntry(file, parameters);

                byte[] buff = new byte[BUFF_SIZE];
                int readLen;
                while ((readLen = inputStream.read(buff)) != -1) {
                    zipOutputStream.write(buff, 0, readLen);
                }

                zipOutputStream.closeEntry();
                System.out.println("Done packaging of file " + "\t" + "\t" + file.getPath());

            } catch (IOException | ZipException e) {
                e.printStackTrace();
            }
        }

        void zipDirectory (File file, ZipOutputStream zipOutputStream, ZipParameters parameters) {
            try {
                zipOutputStream.putNextEntry(file, parameters);
                zipOutputStream.closeEntry();
                System.out.println("Done packaging of folder " + "\t" + "\t" + file.getPath());
                File[] files = file.listFiles();
                if (files != null) {
                    if (files.length !=0) {
                        for (File fileDir: files) {
                            if (fileDir.isDirectory()) {
                                zipDirectory(fileDir, zipOutputStream, parameters);
                            } else {
                                zipFile(fileDir, zipOutputStream, parameters);
                            }
                        }
                    }
                }
            } catch (ZipException | IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Creates archive with password and then stores it to assigned target.
     *
     * @param input  the data to be written
     * @param output the target where archive will be store
     * @param psw    password of archive
     */
    @Override
    public void packArchive(InputStream input, OutputStream output, String psw) {

        try (BufferedOutputStream buffOut = new BufferedOutputStream(output);
             ZipOutputStream zipOutputStream = new ZipOutputStream(buffOut)) {
            // Create ZipParameters object which define various properties
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
            parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
            parameters.setPassword(psw.toCharArray());

            Parser parser = new Parser();
            // Initiate File object which represent file or directory that will be store
            File file = parser.getFile(input);

            parameters.setDefaultFolderPath(file.getParentFile().getAbsolutePath());

            if (file.isDirectory()){
                parser.zipDirectory(file, zipOutputStream, parameters);
            } else {
                if (file.isFile()){
                   parser.zipFile(file, zipOutputStream, parameters);
                }
            }

            zipOutputStream.finish();

            PasswordIntoCache.setPasswordToCache();

        } catch (IOException | ZipException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Extracts contents from archive
     *
     * @param input the archive
     * @param output the target where extracting contents will be store
     * @param password password of archive
     */
    @Override
    public void unpackArchive(InputStream input, OutputStream output, String password) {

        final int BUFF_SIZE = 4096;

        Parser parser = new Parser();

        File inputFile = parser.getFile(input);
        if (!inputFile.exists()) {
            System.out.println("File " + inputFile.getPath() + " does not exist!");
            System.exit(0);
        }

        // Get the FileOutputMode object which contain File object that
        // represent directory where archive file will be unpacked
        FileOutputMode fileOutputMode = (FileOutputMode) ArchiveMode.getArchiveMode().getOutputMode();
        // Get the File object that represent directory where archive file will be store
        File destinationPath = fileOutputMode.getFile();

        try {

            // Initiate ZipFile object that represent archive file
            ZipFile zipFile = new ZipFile(inputFile);

            if (zipFile.isEncrypted()) {
                String psw = password + PasswordIntoCache.getPasswordFromCache();
                zipFile.setPassword(psw.toCharArray());
            }

            List fileHeaderList = zipFile.getFileHeaders();

            for (Object aFileHeader : fileHeaderList) {
                FileHeader fileHeader = (FileHeader) aFileHeader;
                if (fileHeader != null) {

                    String outFilePath = destinationPath.getPath() + File.separator
                            + fileHeader.getFileName();
                    File outFile = new File(outFilePath);

                    if (fileHeader.isDirectory()) {
                        outFile.mkdirs();
                        continue;
                    }

                    File parentDir = outFile.getParentFile();
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    try (ZipInputStream zipInputStream = zipFile.getInputStream(fileHeader);
                         OutputStream outputStream = new FileOutputStream(outFile)) {

                        int readLen;
                        byte[] buff = new byte[BUFF_SIZE];

                        // Read File and write the content to the output stream
                        while ((readLen = zipInputStream.read(buff)) != -1) {
                            outputStream.write(buff, 0, readLen);
                        }

                    }

                    // To restore File attributes
                    UnzipUtil.applyFileAttributes(fileHeader, outFile);

                    System.out.println("Done extracting " + fileHeader.getFileName());
                } else {
                    System.out.println("fileHeader is null!");
                }
            }

        } catch (ZipException | IOException e) {
            e.printStackTrace();
        }
    }

}
