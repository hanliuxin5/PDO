package com.pdc.lychee.planetdefenseoffice.base.activity;

import android.os.Bundle;
import android.view.Window;

import com.pdc.lychee.planetdefenseoffice.helper.DeviceHelper;


/**
 * Created by lychee on 2016/5/5.
 */
public abstract class BaseActivity extends BaseRxActivity {

    public int mState = STATE_NONE;
    public static final int STATE_NONE = 0;
    public static final int STATE_REFRESHING = 1;

    protected abstract int setContentView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        //装载布局
        setContentView(setContentView());
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            //隐藏软件键盘
            DeviceHelper.hideSoftInput(this, getCurrentFocus());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
