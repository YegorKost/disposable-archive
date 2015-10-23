package com.yegor.initializeMode;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.interfaces.InitializeMode;
import com.yegor.interfaces.ProgramMode;
import com.yegor.modes.programMode.ModeOfProgram;

/**
 * This class initialize either program works on pack or unpack mode.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializeProgramMode implements InitializeMode {

    private String option;

    public InitializeProgramMode(String option) {
        this.option = option;
    }

    /**
     * This method initializes a mode of  program.
     */
    @Override
    public void initMode() {
        if (option != null) {
            switch (option) {
                case ("p"): initAction(option);
                    break;
                case ("unp"): initAction(option);
                    break;
            }
        }
    }

    void initAction(String option) {
        ArchiveMode archiveMode = ArchiveMode.getArchiveMode();
        ProgramMode programMode = new ModeOfProgram();
        programMode.setMode(option);
        archiveMode.setProgramMode(programMode);
        System.out.println("Program mode: " + programMode.getClass().getSimpleName());
    }
}
