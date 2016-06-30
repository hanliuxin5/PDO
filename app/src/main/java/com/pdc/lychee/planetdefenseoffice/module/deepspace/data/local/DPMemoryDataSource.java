package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.local;

import android.support.v4.util.LruCache;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;

/**
 * Created by lychee on 2016/6/30.
 */
public class DPMemoryDataSource {

    final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);//获取应用在系统中的最大内存分配,分配1/8的应用内存作为缓存空间

    final int cacheSize = maxMemory / 8;

    private LruCache<String, DeepSpaceBean> cache = new LruCache<>(cacheSize);

    private volatile static DPMemoryDataSource INSTANCE;

    private DPMemoryDataSource() {
    }

    public static DPMemoryDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (DPMemoryDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DPMemoryDataSource();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * @param key yyyy-MM-dd
     * @return
     */
    public DeepSpaceBean get(String key) {
        if (key != null)
            return cache.get(key);
        return null;
    }

    /**
     * @param key   yyyy-MM-dd
     * @param value
     */
    public void put(String key, DeepSpaceBean value) {
        if (key != null && !"".equals(key) && value != null) {
            cache.put(key, value);
        }
    }

    public void clearAll() {
        cache.evictAll();
    }

    public void clear(String key) {
        if (key != null && !"".equals(key)) {
            cache.remove(key);
        }
    }
}
