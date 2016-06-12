package com.pdc.lychee.planetdefenseoffice.base.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;


import com.pdc.lychee.planetdefenseoffice.R;

import butterknife.Bind;

/**
 * Created by lychee on 2016/5/5.
 */
public abstract class BaseHoldBackActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.contentFrame)
    FrameLayout contentFrame;

    private String mTitle = "";
    private String mSubTitle = "";

    @Override
    protected int setContentViewResId() {
        return R.layout.base_activity_holdback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewResId();

    }

    /**
     * 如果有Toolbar需要设置
     *
     * @param toolbar
     */
    protected void initToolbarNav(Toolbar toolbar) {
        if (toolbar == null) {
            throw new RuntimeException("Toolbar is null!");
        }
        //需要手动主设置一次，不然好像之后的设置不会起作用
        toolbar.setTitle("");
        //设置主标题
        toolbar.setTitle(mTitle);
        //设置副标题
        toolbar.setSubtitle(mSubTitle);
        setSupportActionBar(toolbar);
        //设置返回图标
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_grey);
        //返回图标按钮的监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    /**
     * 设置主标题
     *
     * @param mTitle
     */
    protected void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    /**
     * 设置副标题
     *
     * @param mSubTitle
     */
    protected void setmSubTitle(String mSubTitle) {
        this.mSubTitle = mSubTitle;
    }
}
