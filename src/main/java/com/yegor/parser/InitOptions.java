package com.yegor.parser;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.ArrayList;

/**
 * A class creates an <code>Options</code> object and <code>Option</code> is added to it.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitOptions {

    private Options options = new Options();

    public void initializeOptions () {

        Option help = new Option("h", "help", false, "print this masage");
        Option pack = new Option("p", "pack", false, "initiate pack mode");
        Option unpack = new Option("unp", "unpack", false, "initiate unpack mode");
        Option inputFile = new Option("if","input-file", true, "initiate input file mode");
        Option outputFile = new Option("of", "output-file", true, "initiate output file mode");
        Option passwordHC = new Option("pswHC", "passwordHC", true, "initiate passwordHC mode");
        Option library = new Option("lib", true, "initiate library for pack and unpack");

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
