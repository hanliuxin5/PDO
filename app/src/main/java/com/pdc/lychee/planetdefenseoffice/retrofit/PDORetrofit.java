package com.pdc.lychee.planetdefenseoffice.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by lychee on 2016/3/29.
 */
public class PDORetrofit {
    private static Retrofit retrofit = null;
    private static PDOServices apiService = null;
    private static OkHttpClient okHttpClient = null;


    public static PDOServices getApiService() {
        if (apiService != null) {
            return apiService;
        } else {
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(7, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                    .build();
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(PDOServices.BASE_URL)
                    .build();
            apiService = retrofit.create(PDOServices.class);
        }
        return getApiService();
    }

}
