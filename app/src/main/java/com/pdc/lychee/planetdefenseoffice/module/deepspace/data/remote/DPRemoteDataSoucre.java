package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote;

import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPDataSoucre;
import com.pdc.lychee.planetdefenseoffice.retrofit.PDORetrofit;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by lychee on 2016/6/16.
 */
public class DPRemoteDataSoucre implements DPDataSoucre {
    private volatile static DPRemoteDataSoucre INSTANCE;

    private DPRemoteDataSoucre() {
    }

    public static DPRemoteDataSoucre getInstance() {
        if (INSTANCE == null) {
            synchronized (DPRemoteDataSoucre.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DPRemoteDataSoucre();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Observable getDP(String date, boolean hd) {
        return PDORetrofit.getApiService().getAPOD(date, hd)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public void saveDP() {

    }
}
