package com.yegor.disposableArchive;


import com.yegor.interfaces.*;
import com.yegor.parser.ParseCmd;

/**
 * The main class that start the program
 */
public class DisposableArchive {

    public static void main (String[] args) {

        ParseCmd parseCmd = new ParseCmd();
        parseCmd.parseAndInit(args);

        if (!parseCmd.isHelpOption()) {
            ArchiveMode archiveMode = ArchiveMode.getArchiveMode();
            if (archiveMode.isInitialized()) {
                LibMode libMode = archiveMode.getLibMode();
                InputMode inputMode = archiveMode.getInputMode();
                OutputMode outputMode = archiveMode.getOutputMode();
                PasswordMode passwordMode = archiveMode.getPasswordMode();
                ProgramMode programMode = archiveMode.getProgramMode();
                programMode.startAction(libMode, inputMode, outputMode, passwordMode);
            } else {
                archiveMode.getState();
                System.out.println("Enter Library mode, Password mode, Input modem, Output mode and Program mode.\n" +
                        "Example: \n" +
                        "\"-lib zip4j " +
                        "-passwordHC 123 " +
                        "-input-file \"path to a file or directory that will be packed\" " +
                        "-output-file \"path to an archive file where data will be packed\" " +
                        "-pack\"\n" +
                        "All available options you will sea if enter \"-h\" option");
            }
        }

    }

}
