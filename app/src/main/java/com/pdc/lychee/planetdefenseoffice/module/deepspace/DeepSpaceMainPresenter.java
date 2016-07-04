package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import android.text.TextUtils;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPRepository;
import com.pdc.lychee.planetdefenseoffice.retrofit.XIAOHUException;
import com.pdc.lychee.planetdefenseoffice.utils.LogUtil;
import com.pdc.lychee.planetdefenseoffice.utils.TimeUtil;
import com.pdc.lychee.planetdefenseoffice.view.EmptyLayout;
import com.trello.rxlifecycle.FragmentEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceMainPresenter implements DeepSpaceMainContact.Presenter {
    private final DeepSpaceMainContact.View mDeepSpaceMainView;
    private final DPRepository mDpRepository;

    private static String mDate = "";
    private boolean mIsRefresh;

    public DeepSpaceMainPresenter(DPRepository dpRepository, DeepSpaceMainContact.View deepSpaceMainView) {
        mDeepSpaceMainView = deepSpaceMainView;
        mDpRepository = dpRepository;
        mDeepSpaceMainView.setPresenter(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start() {
        mDpRepository.loadDP()
                .compose(((DeepSpaceMainFragment) mDeepSpaceMainView).bindUntilEvent(FragmentEvent.DESTROY_VIEW))
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mDeepSpaceMainView.showLoading();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DeepSpaceBean>() {
                    @Override
                    public void onCompleted() {
                        mDeepSpaceMainView.showLoadFinished(EmptyLayout.EMPTY_DATA);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        if (throwable instanceof XIAOHUException) {
                            XIAOHUException xiaohuException = (XIAOHUException) throwable;
                            LogUtil.d("loadDP---onError：" + xiaohuException.getCode());
                            mDeepSpaceMainView.setFooterView(DeepSpaceAdapter.STATE_LOAD_ERROR);
                        }
                        mDeepSpaceMainView.showLoadFinished(EmptyLayout.EMPTY_DATA);
                    }

                    @Override
                    public void onNext(DeepSpaceBean deepSpaceBean) {
                        mDeepSpaceMainView.addDP(deepSpaceBean);
                        mDate = deepSpaceBean.getDate();
                    }
                });
    }

    @SuppressWarnings("unchecked")
    @Override
    public void loadDP(final String date) {
        mDpRepository.getDP(date)
                .compose(((DeepSpaceMainFragment) mDeepSpaceMainView).bindUntilEvent(FragmentEvent.DESTROY_VIEW))
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mDeepSpaceMainView.showLoading();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DeepSpaceBean>() {
                    @Override
                    public void onCompleted() {
                        mDeepSpaceMainView.showLoadFinished(EmptyLayout.LOAD_FAILED);
                        mIsRefresh = false;
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        if (throwable instanceof HttpException) {
                            HttpException httpException = (HttpException) throwable;
                            LogUtil.d("loadDP---onError：" + httpException.code());
                            mDeepSpaceMainView.setFooterView(DeepSpaceAdapter.STATE_LOAD_ERROR);

                        } else if (throwable instanceof XIAOHUException) {
                            XIAOHUException xiaohuException = (XIAOHUException) throwable;
                            LogUtil.d("loadDP---onError：" + xiaohuException.getCode());
                            mDeepSpaceMainView.setFooterView(DeepSpaceAdapter.STATE_LOAD_ERROR);
                        }
                        mDeepSpaceMainView.showLoadFinished(EmptyLayout.LOAD_FAILED);
                        mIsRefresh = false;
                    }

                    @Override
                    public void onNext(DeepSpaceBean deepSpaceBean) {
                        if (mIsRefresh) {
                            mDeepSpaceMainView.clearRecyclerView();
                            mDeepSpaceMainView.addDP(deepSpaceBean);
                        } else {
                            mDeepSpaceMainView.addDP(deepSpaceBean);
                        }

                    }
                });
    }

    @Override
    public void deleteDP(String date) {
        if (TextUtils.isEmpty(date)) {
            return;
        }
        mDpRepository.deleteDP(date);
        mDeepSpaceMainView.removeDP(date);
    }


    @Override
    public void onReloadClick() {
        mDeepSpaceMainView.showReloadOnError();
        LogUtil.d("点击刷新：" + mDate);
        setDate();
        loadDP(getDate());
    }

    @Override
    public void onLoadMore() {
        mDeepSpaceMainView.showLoadMore();
        mDate = TimeUtil.theDayBefore(mDate);
        LogUtil.d("准备加载更多：" + mDate);
        if (TextUtils.isEmpty(mDate)) {
            onRefresh();
            return;
        }
        loadDP(mDate);
    }

    @Override
    public void onRefresh() {
        LogUtil.d("下拉刷新：" + mDate);
        mDeepSpaceMainView.showRefresh();
        mIsRefresh = true;
        setDate();
        loadDP(getDate());
    }

    @Override
    public void setDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mDate = dateFormat.format(date);
    }

    @Override
    public String getDate() {
        return mDate;
    }
}
