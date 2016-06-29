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

import javax.net.ssl.SSLException;

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

    private String mDate = "";
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
                        if (throwable instanceof HttpException) {
                            HttpException httpException = (HttpException) throwable;
                            if (httpException.code() == 400) {
                                mDeepSpaceMainView.showLoadError("（400）无权访问当前日期！");
                                mDeepSpaceMainView.showNoMoreDP();

                            }
                            if (httpException.code() == 500) {
                                mDeepSpaceMainView.showLoadError("（500）内部错误");
                                mDeepSpaceMainView.showNoMoreDP();
                            }
                        } else if (throwable instanceof SSLException) {
                            mDeepSpaceMainView.showLoadError("网络出现问题");
                        } else if (throwable instanceof XIAOHUException) {
                            XIAOHUException xiaohuException = (XIAOHUException) throwable;
                            if (xiaohuException.getCode() == XIAOHUException.DB_QUERY) {
                                mDeepSpaceMainView.showLoadError("DP查询操作出错");
                            }

                        } else {
                            mDeepSpaceMainView.showLoadError("未知错误");
                            LogUtil.e(throwable.getMessage() == null ? "未知错误" : throwable.getMessage());
                        }
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
                                mDeepSpaceMainView.showLoadError("DP查询操作出错");
                            }
                        } else {
                            mDeepSpaceMainView.showLoadError("未知错误");
                            LogUtil.e(throwable.getMessage());
                        }
                    }

                    @Override
                    public void onNext(DeepSpaceBean deepSpaceBean) {
                        if (deepSpaceBean != null) {
                            mDeepSpaceMainView.addDP(deepSpaceBean);
                            mDate = deepSpaceBean.getDate();
                        } else {
                            onRefresh();
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
    public void onLoadFailedClick() {
        mDeepSpaceMainView.showReloadOnError();
        onRefresh();
    }

    @Override
    public void onLoadMore() {
        mDate = TimeUtil.theDayBefore(mDate);

        mDeepSpaceMainView.showLoadMore();
        loadDP(mDate);
    }

    @Override
    public void onRefresh() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mDate = dateFormat.format(date);

        mDeepSpaceMainView.showRefresh();
        mIsRefresh = true;
        loadDP(mDate);
    }

    @Override
    public String getDate() {
        return mDate;
    }
}
