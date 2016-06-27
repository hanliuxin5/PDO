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
     * @param date YYYY-MM-DD 日期
     */
    Observable getDP(String date);

    Observable firstLoadDP();

    void saveDP(DeepSpaceBean deepSpaceBean);

    void deleteALLDPs();

    void deleteDP(String date);
}
