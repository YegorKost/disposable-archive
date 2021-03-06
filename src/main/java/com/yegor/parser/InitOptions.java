package com.yegor.parser;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * A class creates an <code>Options</code> object and <code>Option</code> is added to it.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitOptions {

    private Options options = new Options();

    public void initializeOptions () {

        Option help = new Option("h", "help", false, "- print this massage");
        Option pack = new Option("p", "pack", false, "- initiate Program mode. This parameter indicates that " +
                "program works in packaging mode.");
        Option unpack = new Option("unp", "unpack", false, "- initiate Program mode. This parameter indicates that " +
                "program works in unpacking mode.");
        Option inputFile = new Option("if","input-file", true, "- initiate Input mode. " +
                "In packaging mode this option has argument (path to file or directory) " +
                "that defines files and directories that will be packed. " +
                "In unpacking mode this option has argument (path to an archive file) " +
                "that defines archive file that will be unpacked.");
        Option outputFile = new Option("of", "output-file", true, "- initiate Output mode. " +
                "In packaging mode this option has argument (path to a file) " +
                "that defines an archive file, where data will be packed." +
                "In unpacking mode this option has argument (path to a directory) " +
                "that defines directory, where data will be unpacked.");
        Option passwordHC = new Option("pswHC", "passwordHC", true, "- initiate Password mode. " +
                "This mode creates password of archive which consist of a user password (argument of this option) " +
                "and password generated by program. HashCode (HC) is used for creation the second part of password.");
        Option library = new Option("lib", true, "- initiate Library mode. API for packaging and unpacking modes." +
                " Available arguments for this option: \"zip4j\".");

        options.addOption(help);
        options.addOption(pack);
        options.addOption(unpack);
        options.addOption(inputFile);
        options.addOption(outputFile);
        options.addOption(passwordHC);
        options.addOption(library);

    }

    public Options getOptions() {
        return options;
    }

}
