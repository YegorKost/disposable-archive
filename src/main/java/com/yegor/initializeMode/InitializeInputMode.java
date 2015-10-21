package com.yegor.initializeMode;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.interfaces.InitializeMode;
import com.yegor.interfaces.InputMode;
import com.yegor.modes.inputModes.FileInputMode;

/**
 * This class initializes a mode of <code>input</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializeInputMode implements InitializeMode {

    private String option, value;

    public InitializeInputMode (String option, String value) {
        this.option = option;
        this.value = value;
    }

    /**
     * This method initializes a input mode of  program.
     *
     */
    @Override
    public void initMode() {
        // Get ArchiveMode object and store input mode
        ArchiveMode archiveMode = ArchiveMode.getArchiveMode();
        InputMode inputMode;
        switch (option) {
            case ("if"): inputMode = new FileInputMode();
                inputMode.setInputModeForPack(value);
                inputMode.setInputModeForUnpack(value);
                // Set input mode
                archiveMode.setInputMode(inputMode);
                System.out.println("Input mode: " + inputMode.getClass().getSimpleName());
                break;
        }

    }
}
