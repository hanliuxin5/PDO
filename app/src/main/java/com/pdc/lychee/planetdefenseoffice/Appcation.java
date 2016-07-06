package com.pdc.lychee.planetdefenseoffice;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

import com.squareup.picasso.Picasso;

/**
 * Created by lychee on 2016/4/7.
 */
public class Appcation extends Application {
    public static boolean sIsAtLeastGB;
    public static Context _context;
    public static Resources _resource;

//    final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);//获取应用在系统中的最大内存分配
//    final int cacheSize = maxMemory / 8;    //分配1/8的应用内存作为缓存空间

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            sIsAtLeastGB = true;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        _resource = _context.getResources();
//        LeakCanary.install(this);
        setupPicasso();
    }

    private void setupPicasso() {
        Picasso picasso = new Picasso.Builder(this)
//                .memoryCache(new LruCache(cacheSize))
                .build();
        Picasso.setSingletonInstance(picasso);
    }
}
