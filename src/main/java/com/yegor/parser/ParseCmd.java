package com.yegor.parser;

import org.apache.commons.cli.*;

/**
 * A class parses command line arguments.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class ParseCmd {

    private String[] args;
    private InitOptions options = new InitOptions();

    ParseCmd(String[] args) {
        // receive the command line arguments
        this.args = args;
        // initialize defined options
        options.initializeOptions();
    }

    public void parse () {
        // create command line parser
        CommandLineParser parser = new DefaultParser();

        try {
            // parse the command line arguments
            CommandLine commandLine = parser.parse(options.getOptions(), args);

//            some code will be here

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
