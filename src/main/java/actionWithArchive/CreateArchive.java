package actionWithArchive;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Администратор on 29.08.2015.
 */
public class CreateArchive {

    public void createArchive(File file, String pathToArchive) {

        try(FileOutputStream fileOutputStream = new FileOutputStream(pathToArchive);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream)){

            ZipEntry zipEntry;
            ArrayList<File> files = new AllFiles().getFiles(file);

            for (File f: files){
                try(FileInputStream fileInputStream = new FileInputStream(f);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)){
                   zipEntry = new ZipEntry(f.getName());
                    zipOutputStream.putNextEntry(zipEntry);
                    int i;
                    while((i = bufferedInputStream.read()) != -1) {
                        zipOutputStream.write(i);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
