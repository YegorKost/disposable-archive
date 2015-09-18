package com.yegor.interfaces;

/**
 * This interface defines the mode of password creation.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface PasswordMode {

    /**
     * @return the general password for archive
     */
    String getPassword();

    /**
     * Method generates general password. It must call method
     * <code>{@link PasswordMode#setSecondPartOfPassword(java.lang.String)}</code>.
     * @param userPsw the user password
     */
    void setPassword(String userPsw);

    /**
     * @return the second part of general password for archive
     */
    String getSecondPartOfPassword();

    /**
     * Method generate the second part of general password for archive.
     * @param secondPartOfPsw parameter for generate <i>secondPartOfPsw</i> password
     */
    void setSecondPartOfPassword(String secondPartOfPsw);
}
