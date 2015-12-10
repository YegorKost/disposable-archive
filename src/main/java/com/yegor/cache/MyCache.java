package com.yegor.cache;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.FailureMode;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * This class interact with cache.
 *
 * @author Yegor Kostochka
 * @version 1.0
 */
public class MyCache {

    private static MyCache myCache = null;

    private MemcachedClient mc = null;

    private MyCache() {}

    public static MyCache getCache() {
        return myCache == null ? new MyCache(): myCache;
    }

    public void connectToCache() {

        AuthDescriptor ad = new AuthDescriptor(null,
                new PlainCallbackHandler("Yegor", "Yegor"));

        try {
            mc = new MemcachedClient(
                    new ConnectionFactoryBuilder()
                            .setProtocol(ConnectionFactoryBuilder.Protocol.BINARY)
                            .setAuthDescriptor(ad).setFailureMode(FailureMode.Retry).build(),
                    AddrUtil.getAddresses("pub-memcache-11537.us-east-1-4.6.ec2.redislabs.com:11537"));
        } catch (IOException e) {
            // handle exception
        }
    }

    public void closeConnection() {
        mc.shutdown(1L, TimeUnit.SECONDS);
    }

    public void setValue(String key, Object value) {
        mc.set(key, 60*60*24*30, value);
    }

    public String getValue(String value) {
        return (String)mc.get(value);
    }

    public void removeValue(String key) {
        mc.delete(key);
    }

}
