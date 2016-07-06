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

import javax.net.ssl.SSLException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;
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
    private boolean mIsRefresh = false;
    private boolean mIsLoadMore = false;
    private Observer<DeepSpaceBean> load;
    private Observer<DeepSpaceBean> start;

    public DeepSpaceMainPresenter(DPRepository dpRepository, DeepSpaceMainContact.View deepSpaceMainView) {
        mDeepSpaceMainView = deepSpaceMainView;
        mDpRepository = dpRepository;
        mDeepSpaceMainView.setPresenter(this);
        start = new Subscriber<DeepSpaceBean>() {
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
                mDeepSpaceMainView.setFooterView(DeepSpaceAdapter.STATE_LOAD_MORE);
                mDeepSpaceMainView.addDP(deepSpaceBean);
                mDate = deepSpaceBean.getDate();

            }
        };
        load = new Observer<DeepSpaceBean>() {
            @Override
            public void onCompleted() {
                mDeepSpaceMainView.showLoadFinished(EmptyLayout.LOAD_FAILED);
                mIsRefresh = false;
                mIsLoadMore = false;
            }

            @Override
            public void onError(Throwable throwable) {
                if (throwable instanceof HttpException) {
                    HttpException httpException = (HttpException) throwable;
                    LogUtil.d("loadDP---onError：" + httpException.code());
                    if (mIsLoadMore) {
                        mDeepSpaceMainView.setFooterView(DeepSpaceAdapter.STATE_LOAD_ERROR);
                    }
                    if (mIsRefresh) {
                        mDeepSpaceMainView.clearRecyclerView();
                        start();
                    }
                } else if (throwable instanceof SSLException) {
                    LogUtil.d("loadDP---onError：SSL握手失败");
                    if (mIsLoadMore) {
                        mDeepSpaceMainView.setFooterView(DeepSpaceAdapter.STATE_LOAD_ERROR);
                    }
                    if (mIsRefresh) {
                        mDeepSpaceMainView.clearRecyclerView();
                        start();
                    }
                } else if (throwable instanceof XIAOHUException) {
                    XIAOHUException xiaohuException = (XIAOHUException) throwable;
                    LogUtil.d("loadDP---onError：" + xiaohuException.getCode());
                    mDeepSpaceMainView.setFooterView(DeepSpaceAdapter.STATE_LOAD_ERROR);
                }
                LogUtil.d("loadDP---onError：" + throwable.getMessage() + ",出错date：" + getDate());
                mDeepSpaceMainView.showLoadFinished(EmptyLayout.LOAD_FAILED);
                mIsRefresh = false;
                mIsLoadMore = false;
            }

            @Override
            public void onNext(DeepSpaceBean deepSpaceBean) {
                mDeepSpaceMainView.setFooterView(DeepSpaceAdapter.STATE_LOAD_MORE);
                if (mIsRefresh) {
                    mDeepSpaceMainView.clearRecyclerView();
                    mDeepSpaceMainView.addDP(deepSpaceBean);

                } else {
                    mDeepSpaceMainView.addDP(deepSpaceBean);
                }
                mDate = deepSpaceBean.getDate();
            }
        };

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
                .subscribe(start);
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
                .subscribe(load);
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
        mIsRefresh = true;
        mIsLoadMore = false;
        mDeepSpaceMainView.showReloadOnError();
        mDeepSpaceMainView.clearRecyclerView();

        setDate("");
        LogUtil.d("点击刷新：" + getDate());
        loadDP(getDate());
    }

    @Override
    public void onLoadMore() {
        mIsLoadMore = true;
        mIsRefresh = false;
        mDeepSpaceMainView.showLoadMore();
        setDate(TimeUtil.theDayBefore(mDate));
        LogUtil.d("准备加载更多：" + mDate);
        loadDP(getDate());
    }

    @Override
    public void onRefresh() {
        mIsRefresh = true;
        mIsLoadMore = false;
        mDeepSpaceMainView.showRefresh();

        setDate("");
        LogUtil.d("下拉刷新：" + getDate());
        loadDP(getDate());
    }

    @Override
    public void setDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (TextUtils.isEmpty(date)) {
            Date date1 = new Date();
//            mDate = dateFormat.format(date1);
            //考虑到时差问题和接口，默认刷新日期为UTC-8日期前一天
            mDate = TimeUtil.theDayBefore(dateFormat.format(date1));
        } else {
            mDate = date;
        }
    }

    @Override
    public String getDate() {
        return mDate;
    }
}
