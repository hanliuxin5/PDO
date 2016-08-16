package com.pdc.lychee.planetdefenseoffice.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.pdc.lychee.planetdefenseoffice.MainApplication;

/**
 * Created by lychee on 2016/6/21.
 */
public class ToastUtil {
    /**
     * 保证在UI线程中显示最新的一次Toast
     */
    private static Toast mToast = null;
    private static Handler mHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            if (mToast != null) {
                mToast.cancel();
            }
            String text = (String) msg.obj;
            mToast = Toast.makeText(MainApplication._context, text, Toast.LENGTH_SHORT);
            mToast.show();
        }
    };

    public static void toast(String text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    private static void showToast(String text, int duration) {
        mHandler.sendMessage(mHandler.obtainMessage(0, 0, duration, text));
    }
}
