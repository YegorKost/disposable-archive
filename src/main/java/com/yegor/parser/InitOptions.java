package com.yegor.parser;

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

    }

    public Options getOptions() {
        return options;
    }

}
