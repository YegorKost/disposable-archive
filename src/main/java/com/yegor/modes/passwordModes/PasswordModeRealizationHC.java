package com.yegor.modes.passwordModes;

import com.yegor.interfaces.PasswordMode;

/**
 * This class defines a password for archive.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class PasswordModeRealizationHC implements PasswordMode {
    /**
     * User password for archive. It is the part of the general password.
     */
    private String password;

    /**
     * Second part of password for archive. It is the part of the general password.
     */
    private String secondPartOfPassword;

    /**
     * This method returns the user password for archive.
     * @return the user password for archive
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the user password for archive.
     * @param userPsw the user password
     */
    public void setPassword(String userPsw) {
        password = userPsw;
    }

    /**
     * This method returns the second part of password for archive.
     * @return the second part of password for archive
     */
    public String getSecondPartOfPassword() {
        return secondPartOfPassword;
    }

    /**
     * This method sets the second part of password for archive.
     * @param userPsw parameter for generating <i>secondPartOfPassword</i> password
     */
    public void setSecondPartOfPassword(String userPsw) {
        secondPartOfPassword = Integer.toString(userPsw.hashCode());
    }
}
