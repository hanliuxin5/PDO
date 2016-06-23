package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPDataSource;
import com.pdc.lychee.planetdefenseoffice.retrofit.PDORetrofit;

import rx.Observable;

/**
 * Created by lychee on 2016/6/16.
 */
public class DPRemoteDataSource implements DPDataSource {
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

    @Override
    public Observable getDP(String date) {
        return PDORetrofit.getApiService().getAPOD(date);
//                .subscribeOn(Schedulers.io());

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
