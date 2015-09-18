package com.yegor.interfaces;

/**
 * A class that implements the <code>InitializeMode</code> interface
 * can initialize a mode of program.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface InitializeMode {
    /**
     * This method initializes a mode of  program.
     *
     * @param option specifies a mode of  program
     * @param value will be initialized for a mode of  program
     */
    void initMode (String option, String value);
}
