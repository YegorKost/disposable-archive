package com.yegor.modes.programMode;

import com.yegor.interfaces.*;

/**
 * This class defines the mode of program (pack or unpack)
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class ModeOfProgram implements ProgramMode {

    private String mode;

    /**
     * This method sets the mode of program, which defines that program
     * works either on pack or unpack mode.
     *
     * @param mode this parameter specifies the mode of program
     */
    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * This method returns the mode of program, which defines that program
     * works either on pack or unpack mode.
     *
     * @return the mode of program
     */
    @Override
    public String getMode() {
        return mode;
    }

    /**
     * This method starts pack or unpack mode
     */
    @Override
    public void startAction(LibMode libMode, InputMode inputMode, OutputMode outputMode, PasswordMode passwordMode) {
        if (mode.equals("p")) {
            libMode.packArchive(inputMode.getInput(), outputMode.getOutput(), passwordMode.getPassword());
        } else {
            if (mode.equals("unp")) {
                libMode.unpackArchive(inputMode.getInput(), null, passwordMode.getPassword());
            }
        }
    }
}
