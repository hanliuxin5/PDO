package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote;

import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPDataSoucre;

/**
 * Created by lychee on 2016/6/16.
 */
public class DPRemoteDataSoucre implements DPDataSoucre {
    private static DPRemoteDataSoucre INSTANCE;

    private DPRemoteDataSoucre() {
    }

    public static DPRemoteDataSoucre getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DPRemoteDataSoucre();
        }
        return INSTANCE;
    }

    @Override
    public void getDP() {

    }

    @Override
    public void saveDP() {

    }
}
