package actionWithArchive;

import java.io.File;
import java.util.ArrayList;

/**
 * A class create list with archived files.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class AllFiles {

    /**
     * List with archived files.
     */
    private ArrayList<File> files = new ArrayList<>();

    /**
     * Method returns list with archived files.
     * @param file the file or directory will be written to list
     * @return list with archived files
     */
    public ArrayList<File> getFiles(File file) {
        composeFileList(file);
        return files;
    }

    /**
     * Method adds files to list with archived files.
     * @param file the file or directory will be written to list
     */
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
