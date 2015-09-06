package interfases;

/**
 * This class defines the mode of password creation.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public interface CreatePassword {

    /**
     * @return general password for archive
     */
    String getPsw(String userPsw);

    /**
     * Method generates general password (psw). It must call method setPswToMwmcached().
     * @param userPsw user password
     */
    void setPsw(String userPsw);

    /**
     * @return password stored to memcached
     */
    String getPswToMemcached(String userPsw);

    /**
     * Method generate password (part of general password) and stores it to memcached.
     * @param pswToMemcached1 parameter for generate <i>pswToMemcached</i> password
     */
    void setPswToMemcached(String pswToMemcached1);
}
