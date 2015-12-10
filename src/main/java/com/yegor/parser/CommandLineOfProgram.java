package com.yegor.parser;

import org.apache.commons.cli.*;

import java.util.Iterator;

/**
 * A class represents arguments of command line.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class CommandLineOfProgram {

    private static CommandLineOfProgram commandLineOfProgram = null;

    private static InitOptions initOptions  = new InitOptions();

    private static CommandLine commandLine = null;

    private CommandLineOfProgram(String[] args){
        initOptions.initializeOptions();
        // create command line parser
        CommandLineParser parser = new DefaultParser();
        try {
            // parse the command line arguments
            commandLine = parser.parse(initOptions.getOptions(), args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void setCommandLineOfProgram(String[] args){
        if (commandLineOfProgram == null) {
            commandLineOfProgram = new CommandLineOfProgram(args);
        }
    }

    public static CommandLineOfProgram getCommandLineOfProgram() {
        return commandLineOfProgram;
    }

    public boolean hasOption(String option) {
        return commandLine.hasOption(option);
    }

    public String getOptionValue(String option) {
        return commandLine.getOptionValue(option);
    }

    public void printHelp() {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("Disposable Archive", initOptions.getOptions());
    }

    public Iterator getIterator() {
        return commandLine.iterator();
    }
}
