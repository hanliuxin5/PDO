package com.pdc.lychee.planetdefenseoffice.retrofit;

import com.pdc.lychee.planetdefenseoffice.module.deepspace.DeepSpaceBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lychee on 2016/3/29.
 */
public interface PDOServices {

    String BASE_URL = "https://api.nasa.gov";
    String API_KEY = "fH73SSmIlqVYSmpBxlD7u4GIyZ2o3100j9JEWH5O";

    /**
     * 获取每日天文图
     *
     * @param date YYYY-MM-DD（默认当天日期）
     * @param hd   true or false（默认false）
     * @return
     */
    @GET("/planetary/apod?api_key=" + API_KEY)
    Observable<DeepSpaceBean> getAPOD(@Query("date") String date,
                                      @Query("hd") boolean hd);
}
