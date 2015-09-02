package actionWithArchive;

import interfases.CreatePassword;

/**
 * A class extends class Archive with two methods which defines how password will be set.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class ArchivePsw1 extends Archive {

    private CreatePassword createPassword = new CreatePassword() {
        @Override
        public void setPsw(String psw) {

        }

        @Override
        public void setPswToMemcached(String pswToMemcached) {

        }
    };

}
