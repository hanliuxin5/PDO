package com.pdc.lychee.planetdefenseoffice.module.deepspace.data;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.local.DPLocalDataSource;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote.DPRemoteDataSource;
import com.pdc.lychee.planetdefenseoffice.utils.LogUtil;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lychee on 2016/6/16.
 */
public class DPRepository implements DPDataSource {
    private final static String TAG = "DPRepository";
    private volatile static DPRepository INSTANCE = null;

    private final DPRemoteDataSource mDPsRemoteDataSource;
    private final DPLocalDataSource mDPsLocalDataSource;

    private DPRepository(DPRemoteDataSource mDPsRemoteDataSource, DPLocalDataSource mDPsLocalDataSource) {
        this.mDPsRemoteDataSource = mDPsRemoteDataSource;
        this.mDPsLocalDataSource = mDPsLocalDataSource;
    }

    public static DPRepository getInstance(DPRemoteDataSource mDPsRemoteDataSource, DPLocalDataSource mDPsLocalDataSource) {
        if (INSTANCE == null) {
            synchronized (DPRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DPRepository(mDPsRemoteDataSource, mDPsLocalDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Observable firstLoadDP() {
        return mDPsLocalDataSource.getDP()
                .subscribeOn(Schedulers.io());
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
                                    .flatMap(new Func1<DeepSpaceBean, Observable<DeepSpaceBean>>() {
                                        @Override
                                        public Observable<DeepSpaceBean> call(DeepSpaceBean deepSpaceBean) {
                                            return mDPsLocalDataSource.saveDP(deepSpaceBean);
                                        }
                                    });
                        } else {
                            return Observable.just(deepSpaceBean);
                        }
                    }
                });
    }

    @SuppressWarnings("unchecked")
    @Override
    public void saveDP(DeepSpaceBean deepSpaceBean) {
        mDPsLocalDataSource.saveDP(deepSpaceBean)
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.d(TAG + ": saveDP---onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.d(TAG + ": saveDP---onError" + e.getMessage());

                    }

                    @Override
                    public void onNext(Long count) {
                        LogUtil.d(TAG + ": saveDP---onNext---" + count);
                    }
                });
    }

    @SuppressWarnings("unchecked")
    @Override
    public void deleteALLDPs() {
        mDPsLocalDataSource.deleteAllDPs()
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.d(TAG + ": deleteAllDPs---onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.d(TAG + ": deleteAllDPs---onError" + e.getMessage());

                    }

                    @Override
                    public void onNext(Integer count) {
                        LogUtil.d(TAG + ": deleteAllDPs---onNext---" + count);
                    }
                });

    }

    @SuppressWarnings("unchecked")
    @Override
    public void deleteDP(final String date) {
        mDPsLocalDataSource.deleteDP(date)
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.d(TAG + ": deleteDP---onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.d(TAG + ": deleteDP---onError" + e.getMessage());

                    }

                    @Override
                    public void onNext(Integer count) {
                        LogUtil.d(TAG + ": deleteDP---onNext---删除记录条数：" + count);
                    }
                });
    }
}
