package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote.DPRemoteDataSource;
import com.pdc.lychee.planetdefenseoffice.retrofit.XIAOHUException;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lychee on 2016/6/23.
 */
public class DPLocalDataSource {
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

    public Observable getDP() {
        return Observable
                .create(new Observable.OnSubscribe<DeepSpaceBean>() {
                    @Override
                    public void call(Subscriber<? super DeepSpaceBean> subscriber) {
                        DeepSpaceBean deepSpaceBean = null;
                        try {
                            deepSpaceBean = queryDP();
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

    private DeepSpaceBean queryDP() throws Exception {
        DeepSpaceBean deepSpaceBean = null;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME +
                        " ORDER BY " + DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_DATE + " DESC;",
                null);

        if (cursor.moveToFirst()) {
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

    public Observable saveDP(final DeepSpaceBean deepSpaceBean) {
        return Observable
                .create(new Observable.OnSubscribe<Long>() {
                    @Override
                    public void call(Subscriber<? super Long> subscriber) {
                        Long count = 0L;
                        try {
                            count = insertDP(deepSpaceBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_INSERT);
                            subscriber.onError(xiaohuException);
                        }
                        subscriber.onNext(count);
                        subscriber.onCompleted();
                    }
                });
    }

    private long insertDP(DeepSpaceBean deepSpaceBean) {
        long count;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.beginTransaction();  //开始事务
        try {
            ContentValues cv = new ContentValues();
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_DATE, deepSpaceBean.getDate());
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_EXPLANATION, deepSpaceBean.getExplanation());
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_HDURL, deepSpaceBean.getHdurl());
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_TITLE, deepSpaceBean.getTitle());
            cv.put(DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_URL, deepSpaceBean.getUrl());
            count = db.insert(DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME, null, cv);
            db.setTransactionSuccessful();  //设置事务成功完成
            return count;
        } finally {
            db.endTransaction();    //结束事务
            db.close();
        }
    }

    public Observable deleteAllDPs() {
        return Observable
                .create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        Integer count = 0;
                        try {
                            SQLiteDatabase db = mDbHelper.getWritableDatabase();
                            count = db.delete(DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME, null, null);
                            db.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_DELETE);
                            subscriber.onError(xiaohuException);
                        }
                        subscriber.onNext(count);
                        subscriber.onCompleted();
                    }
                });
    }


    public Observable deleteDP(final String date) {
        return Observable
                .create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        Integer count = 0;
                        try {
                            SQLiteDatabase db = mDbHelper.getWritableDatabase();
                            db.delete(DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME,
                                    DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_DATE + "=?",
                                    new String[]{String.valueOf(date)});
                            db.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_DELETE);
                            subscriber.onError(xiaohuException);
                        }
                        subscriber.onNext(count);
                        subscriber.onCompleted();
                    }
                });
    }
}
