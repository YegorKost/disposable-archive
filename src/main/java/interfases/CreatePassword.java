package interfases;

/**
 * This class defines the mode of password creation.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public abstract class CreatePassword {

    String psw;
    String pswToMemcached;

    public String getPsw() {
        return psw;
    }

    public abstract void setPsw(String psw);

    public String getPswToMemcached() {
        return pswToMemcached;
    }

    public abstract void setPswToMemcached(String pswToMemcached);
}
