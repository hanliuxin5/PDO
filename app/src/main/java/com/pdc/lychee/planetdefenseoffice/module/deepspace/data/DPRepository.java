package com.pdc.lychee.planetdefenseoffice.module.deepspace.data;

import rx.Observable;

/**
 * Created by lychee on 2016/6/16.
 */
public class DPRepository implements DPDataSoucre {
    private volatile static DPRepository INSTANCE = null;

    private final DPDataSoucre mTasksRemoteDataSource;

    private DPRepository(DPDataSoucre mTasksRemoteDataSource) {
        this.mTasksRemoteDataSource = mTasksRemoteDataSource;
    }

    public static DPRepository getInstance(DPDataSoucre mTasksRemoteDataSource) {
        if (INSTANCE == null) {
            synchronized (DPRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DPRepository(mTasksRemoteDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Observable getDP(String date, boolean hd) {
        //只从服务器接收数据
        return mTasksRemoteDataSource.getDP(date, hd);
    }

    @Override
    public void saveDP() {
    }
}
