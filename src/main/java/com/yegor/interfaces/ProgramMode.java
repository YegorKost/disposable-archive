package com.yegor.interfaces;

/**
 * This interface defines either program works on pack or unpack mode.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface ProgramMode {

    /**
     * This method sets the mode of program, which defines that program
     * works either on pack or unpack mode.
     * @param programMode this parameter specifies the mode of program
     */
    void setMode(String programMode);

    /**
     * This method returns the mode of program, which defines that program
     * works either on pack or unpack mode.
     * @return the mode of program
     */
    String getMode();

    /**
     * This method starts pack or unpack mode
     */
    void startAction(LibMode libMode, InputMode inputMode, OutputMode outputMode, PasswordMode passwordMode);

}
