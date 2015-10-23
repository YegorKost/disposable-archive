package com.yegor.initializeMode;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.interfaces.InitializeMode;
import com.yegor.interfaces.OutputMode;
import com.yegor.modes.outputModes.FileOutputMode;

/**
 * This class initializes a mode of <code>output</code> object for
 * <code>{@link com.yegor.interfaces.LibMode#packArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> or
 * <code>{@link com.yegor.interfaces.LibMode#unpackArchive(java.io.InputStream, java.io.OutputStream, java.lang.String)}</code> methods.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializeOutputMode implements InitializeMode {

    private String option, value;

    public InitializeOutputMode (String option, String value) {
        this.option = option;
        this.value = value;
    }

    /**
     * This method initializes a output mode of  program.
     *
     */
    @Override
    public void initMode() {
        // Get ArchiveMode object and store output mode
        ArchiveMode archiveMode = ArchiveMode.getArchiveMode();
        OutputMode outputMode;
        if (option != null && value != null) {
            switch (option) {
                case ("of"): outputMode = new FileOutputMode();
                    outputMode.setOutputMode(value);
                    // Set output mode
                    archiveMode.setOutputMode(outputMode);
                    System.out.println("Output mode: " + outputMode.getClass().getSimpleName());
                    break;
            }
        }
    }
}
