package com.yegor.parser;

import com.yegor.initializeMode.*;
import org.apache.commons.cli.*;

import java.util.Iterator;

/**
 * A class parses command line arguments.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class ParseCmd {

    private boolean helpOption = false;

    public void parseAndInit(String[] args) {
        CommandLineOfProgram.setCommandLineOfProgram(args);
        CommandLineOfProgram commandLine = CommandLineOfProgram.getCommandLineOfProgram();

            // if "-h" or "--help" options presence then print only help message
            if (commandLine.hasOption("h")){
                commandLine.printHelp();
                helpOption = true;
            } else {

                Iterator iterator = commandLine.getIterator();

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
                helpOption = false;
            }
    }

    public boolean isHelpOption() {
        return helpOption;
    }
}
