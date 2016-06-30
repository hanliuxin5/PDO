package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import android.text.TextUtils;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPRepository;
import com.pdc.lychee.planetdefenseoffice.retrofit.XIAOHUException;
import com.pdc.lychee.planetdefenseoffice.utils.LogUtil;
import com.pdc.lychee.planetdefenseoffice.utils.TimeUtil;
import com.trello.rxlifecycle.FragmentEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Override
    public void start() {
        loadSavedDP();
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
                        mDeepSpaceMainView.showLoadFinish();
                        mIsRefresh = false;
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        if (throwable instanceof XIAOHUException) {
                            XIAOHUException xiaohuException = (XIAOHUException) throwable;
                            if (xiaohuException.getCode() == XIAOHUException.DB_QUERY) {
                                mDeepSpaceMainView.showLoadError("DP查询操作出错", mIsRefresh);
                            }
                        } else {
                            mDeepSpaceMainView.showLoadError("加载数据时出错", mIsRefresh);
                            LogUtil.e(throwable.getMessage() == null ? "未知错误" : throwable.getMessage());
                        }
                        if (mIsRefresh) {
                            mDeepSpaceMainView.clearRecyclerView();
                            loadSavedDP();
                        } else {
                            mDate = TimeUtil.theDayAfter(mDate);
                        }
                        mIsRefresh = false;
                    }

                    @Override
                    public void onNext(DeepSpaceBean deepSpaceBean) {
                        if (deepSpaceBean != null) {
                            if (mIsRefresh) {
                                mDeepSpaceMainView.clearRecyclerView();
                                mDeepSpaceMainView.addDP(deepSpaceBean);
                            } else {
                                mDeepSpaceMainView.addDP(deepSpaceBean);
                            }
                            if (!deepSpaceBean.getDate().equals("400") && !deepSpaceBean.getDate().equals("500"))
                                mDate = deepSpaceBean.getDate();
                        }
                    }
                });
    }

    @SuppressWarnings("unchecked")
    @Override
    public void loadSavedDP() {
        mDpRepository.firstLoadDP()
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
                        mDeepSpaceMainView.showLoadFinish();
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        if (throwable instanceof XIAOHUException) {
                            XIAOHUException xiaohuException = (XIAOHUException) throwable;
                            if (xiaohuException.getCode() == XIAOHUException.DB_QUERY) {
                                mDeepSpaceMainView.showLoadError("DP查询操作出错", mIsRefresh);
                            }
                        } else {
                            mDeepSpaceMainView.showLoadError("载入本地数据时出错---onError", mIsRefresh);
                            LogUtil.e(throwable.getMessage() == null ? "未知错误" : throwable.getMessage());
                        }
                    }

                    @Override
                    public void onNext(DeepSpaceBean deepSpaceBean) {
                        mDeepSpaceMainView.addDP(deepSpaceBean);
                        mDate = deepSpaceBean.getDate();
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
    public void onLoadFailedClick() {
        mDeepSpaceMainView.showReloadOnError();
        onRefresh();
    }

    @Override
    public void onLoadMore() {
        mDate = TimeUtil.theDayBefore(mDate);
        LogUtil.d("准备加载更多：" + mDate);

        if (TextUtils.isEmpty(mDate)) {
            onRefresh();
            return;
        }
        mDeepSpaceMainView.showLoadMore();
        loadDP(mDate);
    }

    @Override
    public void onRefresh() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mDate = dateFormat.format(date);
//        mDate = "2016-07-01";

        LogUtil.d("下拉刷新：" + mDate);

        mDeepSpaceMainView.showRefresh();
        mIsRefresh = true;
        loadDP(mDate);
    }

    @Override
    public String getDate() {
        return mDate;
    }
}
