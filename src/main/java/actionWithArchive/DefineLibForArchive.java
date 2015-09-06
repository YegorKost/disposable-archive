package actionWithArchive;


import interfases.TypeOfArchive;
import typesOfArchive.LibZip4j;

/**
 * This class defines a library that can be used to create archive
 */
public class DefineLibForArchive {
    String lib;
    public DefineLibForArchive (String lib) {
        this.lib = lib;
    }
    public TypeOfArchive setLib () {
        TypeOfArchive typeOfArchive = null;
        switch (lib){
            case "zip4j": typeOfArchive = new LibZip4j(); break;
            default: typeOfArchive = new LibZip4j(); break;
        }
        return typeOfArchive;
    }

}
