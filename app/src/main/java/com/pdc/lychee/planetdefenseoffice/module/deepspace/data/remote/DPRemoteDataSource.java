package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.retrofit.PDORetrofit;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.functions.Func1;

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
        return PDORetrofit.getApiService().getAPOD(date)
                .onErrorReturn(new Func1<Throwable, DeepSpaceBean>() {
                    @Override
                    public DeepSpaceBean call(Throwable throwable) {
                        DeepSpaceBean deepSpaceBean = null;
                        if (throwable instanceof HttpException) {
                            HttpException httpException = (HttpException) throwable;
                            if (httpException.code() == 400) {
                                deepSpaceBean = new DeepSpaceBean();
                                deepSpaceBean.setDate("400");
                            }
                            if (httpException.code() == 500) {
                                deepSpaceBean = new DeepSpaceBean();
                                deepSpaceBean.setDate("500");
                            }
                        }
                        return deepSpaceBean;
                    }
                });
    }

}
