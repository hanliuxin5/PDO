package com.pdc.lychee.planetdefenseoffice.module.deepspace.data;

/**
 * Created by lychee on 2016/6/16.
 */
public class DPRepository implements DPDataSoucre {
    private static DPRepository INSTANCE = null;

    private final DPDataSoucre mTasksRemoteDataSource;

    private DPRepository(DPDataSoucre mTasksRemoteDataSource) {
        this.mTasksRemoteDataSource = mTasksRemoteDataSource;
    }

    public static DPRepository getInstance(DPDataSoucre mTasksRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DPRepository(mTasksRemoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getDP() {
        mTasksRemoteDataSource.getDP();
    }

    @Override
    public void saveDP() {
        mTasksRemoteDataSource.saveDP();
    }
}
