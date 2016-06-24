package com.pdc.lychee.planetdefenseoffice.module.deepspace.data;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.retrofit.XIAOHUException;
import com.pdc.lychee.planetdefenseoffice.utils.LogUtil;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lychee on 2016/6/16.
 */
public class DPRepository implements DPDataSource {
    private final static String TAG = "DPRepository";
    private volatile static DPRepository INSTANCE = null;

    private final DPDataSource mDPsRemoteDataSource;
    private final DPDataSource mDPsLocalDataSource;

    private DPRepository(DPDataSource mDPsRemoteDataSource, DPDataSource mDPsLoaclDataSource) {
        this.mDPsRemoteDataSource = mDPsRemoteDataSource;
        this.mDPsLocalDataSource = mDPsLoaclDataSource;
    }

    public static DPRepository getInstance(DPDataSource mDPsRemoteDataSource, DPDataSource mDPsLocalDataSource) {
        if (INSTANCE == null) {
            synchronized (DPRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DPRepository(mDPsRemoteDataSource, mDPsLocalDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable getDP(final String date) {
        return mDPsLocalDataSource.getDP(date)
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<DeepSpaceBean, Observable<DeepSpaceBean>>() {
                    @Override
                    public Observable<DeepSpaceBean> call(DeepSpaceBean deepSpaceBean) {
                        if (deepSpaceBean == null) {
                            return mDPsRemoteDataSource.getDP(date)
                                    .doOnNext(new Action1<DeepSpaceBean>() {
                                        @Override
                                        public void call(DeepSpaceBean deepSpaceBean) {
                                            try {
                                                mDPsLocalDataSource.saveDP(deepSpaceBean);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                        } else {
                            return Observable.just(deepSpaceBean);
                        }
                    }
                });
    }

    @Override
    public void saveDP(DeepSpaceBean deepSpaceBean) {
    }

    @Override
    public void deleteALLDPs() {
        mDPsLocalDataSource.deleteALLDPs();
    }

    @Override
    public void deleteDP(final String date) {
        Observable
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        try {
                            mDPsLocalDataSource.deleteDP(date);
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_DELETE);
                            subscriber.onError(xiaohuException);
                        }
                        subscriber.onNext("");
                        subscriber.onCompleted();

                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.d(TAG + ": deleteDP---onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.d(TAG + ": deleteDP---onError" + e.getMessage());

                    }

                    @Override
                    public void onNext(String s) {
                        LogUtil.d(TAG + ": deleteDP---onNext");
                    }
                });
    }
}
