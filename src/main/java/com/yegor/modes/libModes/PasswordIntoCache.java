package com.yegor.modes.libModes;

import com.yegor.disposableArchive.ArchiveMode;
import com.yegor.cache.MyCache;
import com.yegor.parser.CommandLineOfProgram;

import java.io.File;

/**
 * PasswordIntoCache class represents two methods for storing second part of password to cache
 * and getting second part of password from cache.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class PasswordIntoCache {

    /**
     * Method sets the second part of password for archive to cache.
     */
    public static void setPasswordToCache() {
        CommandLineOfProgram commandLine = CommandLineOfProgram.getCommandLineOfProgram();
        String myCacheKey = new File(commandLine.getOptionValue("of")).getName() + commandLine.getOptionValue("pswHC");
        String myCacheValue = ArchiveMode.getArchiveMode().getPasswordMode().getSecondPartOfPassword();
        MyCache myCache = MyCache.getCache();
        myCache.connectToCache();
        myCache.setValue(myCacheKey, myCacheValue);
        myCache.closeConnection();
    }

    /**
     * Method returns the second part of password for archive from cache.
     * @return the second part of password  for archive
     */
    public static String getPasswordFromCache() {
        CommandLineOfProgram commandLine = CommandLineOfProgram.getCommandLineOfProgram();
        String myCacheKey = new File(commandLine.getOptionValue("if")).getName() + commandLine.getOptionValue("pswHC");
        MyCache myCache = MyCache.getCache();
        myCache.connectToCache();
        String myCacheValue = myCache.getValue(myCacheKey);
        if (myCacheValue == null) {
            myCache.closeConnection();
            System.out.println("Wrong password of archive or it can not be unpacked anymore!");
            System.exit(0);
        } else {
            myCache.removeValue(myCacheKey);
            myCache.closeConnection();
        }
        return myCacheValue;
    }

}
