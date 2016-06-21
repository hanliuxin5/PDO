package com.pdc.lychee.planetdefenseoffice.module;

import com.pdc.lychee.planetdefenseoffice.utils.LogUtil;

/**
 * Created by lychee on 2016/6/16.
 */
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mMainView;

    public MainPresenter(MainContract.View mMainView) {
        this.mMainView = mMainView;
    }

    @Override
    public void start() {

    }

    @Override
    public void firstPresenter() {
        LogUtil.i("firstPresenter");
    }
}
