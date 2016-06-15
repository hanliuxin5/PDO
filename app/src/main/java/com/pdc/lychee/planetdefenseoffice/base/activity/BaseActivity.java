package com.pdc.lychee.planetdefenseoffice.base.activity;

import android.os.Bundle;

import com.pdc.lychee.planetdefenseoffice.manager.DeviceManager;


/**
 * Created by lychee on 2016/5/5.
 */
public abstract class BaseActivity extends BaseRxActivity {

    protected abstract int setContentView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //装载布局
        setContentView(setContentView());
    }

    public void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            //隐藏软件键盘
            DeviceManager.hideSoftInput(this, getCurrentFocus());
        }
    }

    public void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
