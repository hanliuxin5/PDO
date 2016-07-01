package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.retrofit.PDORetrofit;

import rx.Observable;

/**
 * Created by lychee on 2016/6/16.
 */
public class DPRemoteDataSource {
    private volatile static DPRemoteDataSource INSTANCE;

    private DPRemoteDataSource() {
    }

    public static DPRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (DPRemoteDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DPRemoteDataSource();
                }
            }
        }
        return INSTANCE;
    }

    public Observable<DeepSpaceBean> getDP(String date) {
        return PDORetrofit.getApiService().getAPOD(date);
    }

}
