package com.yegor.disposableArchive;

import com.yegor.cache.MyCache;
import org.junit.Test;

/**
 * This class tests MyCache class and connection to remote memcached server.
 *
 * @author Ygor Kostochka
 * @version 1.0
 */
public class MyCacheTest {

    String value;

    @Test
    public void testMyCache() {
        MyCache myCache = MyCache.getCache();
        myCache.connectToCache();
        for (int i = 0; i < 10; i++) {
            myCache.setValue(String.valueOf(i), "I am value" + i);
        }
        for (int i = 0; i <10; i++) {
            value = myCache.getValue(String.valueOf(i));
            System.out.println(value);
            org.junit.Assert.assertTrue(("I am value" + i).equals(value));
            myCache.removeValue(String.valueOf(i));
        }
        for (int i = 0; i < 10; i++) {
            value = myCache.getValue(String.valueOf(i));
            org.junit.Assert.assertTrue(value == null);
        }
        myCache.closeConnection();

    }
}