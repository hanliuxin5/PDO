package com.pdc.lychee.planetdefenseoffice;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

/**
 * Created by lychee on 2016/4/7.
 */
public class Appcation extends Application {
    public static boolean sIsAtLeastGB;
    public static Context _context;
    public static Resources _resource;

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

    }
}
