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
     * General password for archive. It consists of user password and password
     * generated by program (<code>{@link PasswordModeRealizationHC#secondPartOfPassword}</code>).
     */
    private String password;

    /**
     * This password stores to another server. It is the part of the general password
     * (<code>{@link PasswordModeRealizationHC#password}</code>).
     */
    private String secondPartOfPassword;

    /**
     * This method returns the general password for archive.
     * @return the general password for archive
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method generates general password (<code>{@link PasswordModeRealizationHC#password}</code>).
     * It must call the method <code>{@link PasswordModeRealizationHC#setSecondPartOfPassword(java.lang.String)}</code>
     * @param userPsw user password
     */
    public void setPassword(String userPsw) {
        setSecondPartOfPassword(userPsw);
        password = userPsw + getSecondPartOfPassword();
    }

    /**
     * This method returns the second part of general password for archive.
     * @return the second part of general password for archive
     */
    public String getSecondPartOfPassword() {
        return secondPartOfPassword;
    }

    /**
     * Method generates password (part of general <code>{@link PasswordModeRealizationHC#password}</code>)
     * and stores it to another server.
     * @param userPsw parameter for generating <i>secondPartOfPsw</i> password
     */
    public void setSecondPartOfPassword(String userPsw) {
        this.secondPartOfPassword = Integer.toString(userPsw.hashCode());
    }
}
