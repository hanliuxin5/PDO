package com.pdc.lychee.planetdefenseoffice.module.deepspace.data;

import rx.Observable;

/**
 * Created by lychee on 2016/6/16.
 */
public interface DPDataSoucre {

    /**
     * 根据参数获取天文图
     *
     * @param date YYYY-MM-DD 日期
     * @param hd   boolean 是否高清
     */
    Observable getDP(String date, boolean hd);

    void saveDP();

}
