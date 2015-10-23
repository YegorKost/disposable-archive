package com.yegor.interfaces;

/**
 * This interface defines the mode of password creation.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface PasswordMode {

    /**
     * This method returns the general password for archive.
     * @return the general password for archive
     */
    String getPassword();

    /**
     * Method generates general password. It must call the method
     * <code>{@link PasswordMode#setSecondPartOfPassword(java.lang.String)}</code>.
     * @param userPsw the user password
     */
    void setPassword(String userPsw);

    /**
     * This method returns the second part of general password for archive.
     * @return the second part of general password for archive
     */
    String getSecondPartOfPassword();

    /**
     * Method generate the second part of general password for archive.
     * @param userPsw parameter for generate <i>secondPartOfPsw</i> password
     */
    void setSecondPartOfPassword(String userPsw);
}
