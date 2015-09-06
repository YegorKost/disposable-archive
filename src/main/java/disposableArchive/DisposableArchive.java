package disposableArchive;


import actionWithArchive.ArchivePsw1;
import actionWithArchive.DefineLibForArchive;

/**
 * The main class that start the program
 */
public class DisposableArchive {

    public static void main (String[] args) {

        ArchivePsw1 archivePsw1 = new ArchivePsw1();
        // Set password
        archivePsw1.setPsw(args[3]);
        // Create object that defines a library that can be used to create archive
        DefineLibForArchive defineLibForArchive = new DefineLibForArchive(args[4]);
        archivePsw1.setTypeOfArchive(defineLibForArchive.setLib());
        // Define mode that be used in program (pack or unpack)
        if (args[0].equals("pack")) {
            System.out.println("Mode pack");
            archivePsw1.createArchive(args[1], args[2]);
        }
        if (args[0].equals("unpack")) {
            System.out.println("Mode unpack");
            archivePsw1.extractFromArchive(args[1], args[2]);
        }

    }

}
