package actionWithArchive;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Администратор on 29.08.2015.
 */
public class AllFiles {

    private ArrayList<File> files = new ArrayList<>();

    public ArrayList<File> getFiles(File file) {
        composeFileList(file);
        return files;
    }

    private void composeFileList (File file) {

        if (file.isDirectory()) {
            for (String f: file.list()){
                composeFileList(new File(f));
            }
        } else {
            files.add(file);
        }

    }

}
