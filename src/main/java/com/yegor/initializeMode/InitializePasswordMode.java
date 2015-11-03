package com.yegor.initializeMode;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.interfaces.InitializeMode;
import com.yegor.interfaces.PasswordMode;
import com.yegor.modes.passwordModes.PasswordModeRealizationHC;

/**
 * This class initializes a mode of password creation.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializePasswordMode implements InitializeMode {
    private String option, value;

    public InitializePasswordMode(String option, String value) {
        this.option = option;
        this.value = value;
    }

    /**
     * This method initializes a password mode of  program.
     *
     */
    @Override
    public void initMode() {
        // Get ArchiveMode object and store password mode
        ArchiveMode archiveMode = ArchiveMode.getArchiveMode();
        PasswordMode passwordMode;
        if (option != null && value != null) {
            switch (option) {
                case "pswHC": passwordMode = new PasswordModeRealizationHC();
                    // Set password
                    passwordMode.setPassword(value);
                    // Set password mode
                    archiveMode.setPasswordMode(passwordMode);
                    break;
            }
        }
    }
}
