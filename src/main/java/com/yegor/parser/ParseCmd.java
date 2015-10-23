package com.yegor.parser;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.initializeMode.*;
import com.yegor.interfaces.*;
import org.apache.commons.cli.*;

import java.util.Iterator;

/**
 * A class parses command line arguments.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class ParseCmd {

    private String[] args;
    private InitOptions initOptions = new InitOptions();

    public ParseCmd(String[] args) {
        // receive the command line arguments
        this.args = args;
        // initialize defined initOptions
        initOptions.initializeOptions();
    }

    public void parse () {
        // create command line parser
        CommandLineParser parser = new DefaultParser();

        try {
            // parse the command line arguments
            CommandLine commandLine = parser.parse(initOptions.getOptions(), args);

            // if "-h" or "--help" options presence then print only help message
            if (commandLine.hasOption("h")){
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("DisposableArchive", initOptions.getOptions());
            } else {

                Iterator iterator = commandLine.iterator();

                while (iterator.hasNext()){
                    Option option = (Option)iterator.next();
                    // Initiate library mode
                    new InitializeLibMode(option.getValue()).initMode();
                    // Initiate password mode
                    new InitializePasswordMode(option.getOpt(), option.getValue()).initMode();
                    // Initiate input mode
                    new InitializeInputMode(option.getOpt(), option.getValue()).initMode();
                    // Initiate output mode
                    new InitializeOutputMode(option.getOpt(), option.getValue()).initMode();
                    // Initialize program mode
                    new InitializeProgramMode(option.getOpt()).initMode();
                }

                ArchiveMode archiveMode = ArchiveMode.getArchiveMode();
                if (archiveMode.isInitialized()) {
                    LibMode libMode = archiveMode.getLibMode();
                    InputMode inputMode = archiveMode.getInputMode();
                    OutputMode outputMode = archiveMode.getOutputMode();
                    PasswordMode passwordMode = archiveMode.getPasswordMode();
                    ProgramMode programMode = archiveMode.getProgramMode();
                    programMode.startAction(libMode, inputMode, outputMode, passwordMode);

                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
