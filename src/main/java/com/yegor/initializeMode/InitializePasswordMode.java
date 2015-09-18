package com.yegor.initializeMode;

import com.yegor.interfaces.InitializeMode;

/**
 * This class initializes a mode of password creation.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class InitializePasswordMode implements InitializeMode {
//    Beginning of old code

//    private String pswMode;
//
//    InitializePasswordMode() {}
//
//    InitializePasswordMode(String pswMode) {this.pswMode = pswMode;}
//
//    public PasswordMode setPasswordMode () {
//        PasswordMode passwordMode = null;
//        switch (pswMode){
//            default: passwordMode = new PasswordModeRealizationHC();
//                System.out.println("Password mode: " + pswMode.getClass().getName()); break;
//        }
//        return passwordMode;
//    }

//    Ending of old code

    /**
     * This method initializes a mode of  program.
     *
     * @param option specifies a mode of  program
     * @param value  will be initialized for a mode of  program
     */
    @Override
    public void initMode(String option, String value) {

    }
}
