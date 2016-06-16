package com.pdc.lychee.planetdefenseoffice.module;

/**
 * Created by lychee on 2016/6/16.
 */
public class MainPrsenter implements MainContract.Presenter {
    private MainContract.View mMainView;

    public MainPrsenter(MainContract.View mMainView) {
        this.mMainView = mMainView;
    }

    @Override
    public void start() {

    }

    @Override
    public void firstPresenter() {

    }
}
