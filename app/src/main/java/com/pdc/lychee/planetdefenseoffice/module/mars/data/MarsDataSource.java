package com.pdc.lychee.planetdefenseoffice.module.mars.data;

import com.pdc.lychee.planetdefenseoffice.a_javabean.MarsImg;

import java.util.List;

/**
 * Created by lychee on 2016/9/19.
 */
public interface MarsDataSource {
    void saveMarsImg(MarsImg img);

    void saveMarsImgs(List<MarsImg> list);

    void loadMarsImgs(String sol, String camera);

    void loadMarsImg(String id);

    void deleteMarsImg(String id);

    void deleteMarsImgs(List<String> ids);

}
