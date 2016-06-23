package com.pdc.lychee.planetdefenseoffice.module.deepspace.data;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by lychee on 2016/6/16.
 */
public class DPRepository implements DPDataSource {
    private volatile static DPRepository INSTANCE = null;

    private final DPDataSource mDPsRemoteDataSource;
    private final DPDataSource mDPsLoaclDataSource;

    private DPRepository(DPDataSource mDPsRemoteDataSource, DPDataSource mDPsLoaclDataSource) {
        this.mDPsRemoteDataSource = mDPsRemoteDataSource;
        this.mDPsLoaclDataSource = mDPsLoaclDataSource;
    }

    public static DPRepository getInstance(DPDataSource mDPsRemoteDataSource, DPDataSource mDPsLoaclDataSource) {
        if (INSTANCE == null) {
            synchronized (DPRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DPRepository(mDPsRemoteDataSource, mDPsLoaclDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable getDP(final String date) {

        return mDPsLoaclDataSource.getDP(date)
//                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<DeepSpaceBean, Observable<DeepSpaceBean>>() {
                    @Override
                    public Observable<DeepSpaceBean> call(DeepSpaceBean deepSpaceBean) {
                        if (deepSpaceBean == null) {
                            return mDPsRemoteDataSource.getDP(date)
                                    .doOnNext(new Action1<DeepSpaceBean>() {
                                        @Override
                                        public void call(DeepSpaceBean deepSpaceBean) {
                                            try {
                                                mDPsLoaclDataSource.saveDP(deepSpaceBean);
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

    }

    @Override
    public void deleteDP(String date) {

    }
}
