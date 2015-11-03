package com.yegor.initializeMode;


import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.interfaces.InitializeMode;
import com.yegor.interfaces.LibMode;
import com.yegor.modes.libModes.LibZip4j;

/**
 * This class initializes a mode (library) that can be used to pack and unpack archive.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializeLibMode implements InitializeMode {

    private String value;

    public InitializeLibMode(String value) {
        this.value = value;
    }

    /**
     * This method initializes a library mode of  program.
     *
     */
    @Override
    public void initMode() {
        // Get ArchiveMode object and store library mode
        ArchiveMode archiveMode = ArchiveMode.getArchiveMode();
        LibMode libMode;
        if (value != null) {
            switch (value) {
                case ("zip4j"): libMode = new LibZip4j();
                    // Set library mode
                    archiveMode.setLibMode(libMode);
                    break;
            }
        }
    }
}
