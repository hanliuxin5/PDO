package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPDataSource;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote.DPRemoteDataSource;
import com.pdc.lychee.planetdefenseoffice.retrofit.XIAOHUException;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lychee on 2016/6/23.
 */
public class DPLocalDataSource implements DPDataSource {
    private volatile static DPLocalDataSource INSTANCE;

    private DPDBHelper mDbHelper;

    private DPLocalDataSource(Context context) {
        mDbHelper = new DPDBHelper(context);
    }

    public static DPLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (DPRemoteDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DPLocalDataSource(context);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Observable getDP(final String date) {
        return Observable
                .create(new Observable.OnSubscribe<DeepSpaceBean>() {
                    @Override
                    public void call(Subscriber<? super DeepSpaceBean> subscriber) {
                        DeepSpaceBean deepSpaceBean = null;
                        try {
                            deepSpaceBean = queryDP(date);
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_QUERY);
                            subscriber.onError(xiaohuException);
                        }
                        subscriber.onNext(deepSpaceBean);
                        subscriber.onCompleted();
                    }
                });
    }

    private DeepSpaceBean queryDP(String mDate) throws Exception {
        DeepSpaceBean deepSpaceBean = null;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " +
                DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME +
                " where " + DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_DATE + "=?", new String[]{String.valueOf(mDate)});

        if (cursor.moveToNext()) {
            deepSpaceBean = new DeepSpaceBean();
            String date = cursor.getString(cursor.getColumnIndex(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_DATE));
            String explanation = cursor.getString(cursor.getColumnIndex(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_EXPLANATION));
            String title = cursor.getString(cursor.getColumnIndex(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_TITLE));
            String hdurl = cursor.getString(cursor.getColumnIndex(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_HDURL));
            String url = cursor.getString(cursor.getColumnIndex(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_URL));
            deepSpaceBean.setDate(date);
            deepSpaceBean.setExplanation(explanation);
            deepSpaceBean.setTitle(title);
            deepSpaceBean.setHdurl(hdurl);
            deepSpaceBean.setUrl(url);
        }
        cursor.close();
        db.close();
        return deepSpaceBean;
    }

    @Override
    public void saveDP(final DeepSpaceBean deepSpaceBean) {
        insertDP(deepSpaceBean);
    }

    private void insertDP(DeepSpaceBean deepSpaceBean) {
//        db.execSQL(
//                "INSERT INTO " + DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME + " VALUES(?, ?, ?, ?, ?)",
//                new Object[]{deepSpaceBean.getDate(),
//                        deepSpaceBean.getExplanation(),
//                        deepSpaceBean.getHdurl(),
//                        deepSpaceBean.getTitle(),
//                        deepSpaceBean.getUrl()
//                });

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.beginTransaction();  //开始事务
        try {
            ContentValues cv = new ContentValues();
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_DATE, deepSpaceBean.getDate());
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_EXPLANATION, deepSpaceBean.getExplanation());
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_HDURL, deepSpaceBean.getHdurl());
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_TITLE, deepSpaceBean.getTitle());
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_URL, deepSpaceBean.getUrl());
            db.insert(DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME, null, cv);
            db.setTransactionSuccessful();  //设置事务成功完成
        } finally {
            db.endTransaction();    //结束事务
            db.close();
        }
    }

    @Override
    public void deleteALLDPs() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.delete(DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME, null, null);

        db.close();
    }

    @Override
    public void deleteDP(String date) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.delete(DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME,
                DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_DATE + "=?",
                new String[]{String.valueOf(date)});

        db.close();
    }
}
