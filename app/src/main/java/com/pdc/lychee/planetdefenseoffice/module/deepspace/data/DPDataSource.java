package com.pdc.lychee.planetdefenseoffice.module.deepspace.data;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;

import rx.Observable;

/**
 * Created by lychee on 2016/6/16.
 */
public interface DPDataSource {

    /**
     * 根据参数获取天文图
     *
     * @param date yyyy-MM-dd 日期
     */
    Observable getDP(String date);

    /**
     * 获取天文图
     *
     * @return
     */
    Observable getDP();

    void saveDP(DeepSpaceBean deepSpaceBean);

    void deleteALLDPs();

    void deleteDP(String date);
}
