package com.yegor.interfaces;

/**
 * This interface defines the mode of password creation.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface PasswordMode {

    /**
     * This method returns the user password for archive.
     * @return the user password for archive
     */
    String getPassword();

    /**
     * This method sets user password for archive.
     * @param userPsw the user password
     */
    void setPassword(String userPsw);

    /**
     * This method returns the second part of password for archive.
     * @return the second part of password for archive
     */
    String getSecondPartOfPassword();

    /**
     * This method sets the second part of password for archive.
     * @param userPsw parameter for generate <i>secondPartOfPsw</i> password
     */
    void setSecondPartOfPassword(String userPsw);
}
