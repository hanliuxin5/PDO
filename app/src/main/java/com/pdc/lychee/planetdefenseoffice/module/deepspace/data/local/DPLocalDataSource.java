package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.local;

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

    public Observable<DeepSpaceBean> getDP(final String date) {
        return Observable
                .create(new Observable.OnSubscribe<DeepSpaceBean>() {
                    @Override
                    public void call(Subscriber<? super DeepSpaceBean> subscriber) {
                        DeepSpaceBean deepSpaceBean = null;
                        try {
                            deepSpaceBean = queryDP(date);
                            subscriber.onNext(deepSpaceBean);
                            subscriber.onCompleted();
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_QUERY);
                            subscriber.onError(xiaohuException);
                        }
                    }
                });
    }

    public Observable<DeepSpaceBean> getDP() {
        return Observable
                .create(new Observable.OnSubscribe<DeepSpaceBean>() {
                    @Override
                    public void call(Subscriber<? super DeepSpaceBean> subscriber) {
                        DeepSpaceBean deepSpaceBean = null;
                        try {
                            deepSpaceBean = queryDP();
                            subscriber.onNext(deepSpaceBean);
                            subscriber.onCompleted();
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_QUERY);
                            subscriber.onError(xiaohuException);
                        }

                    }
                });
    }

    private DeepSpaceBean queryDP(String mDate) throws Exception {
        DeepSpaceBean deepSpaceBean = null;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " +
                DeepSpaceEntry.TABLE_NAME +
                " where " + DeepSpaceEntry.COLUMN_NAME_DATE + "=?", new String[]{String.valueOf(mDate)});

        if (cursor.moveToNext()) {
            deepSpaceBean = new DeepSpaceBean();
            String date = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_DATE));
            String explanation = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_EXPLANATION));
            String title = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_TITLE));
            String hdurl = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_HDURL));
            String url = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_URL));
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

        Cursor cursor = db.rawQuery("SELECT * FROM " + DeepSpaceEntry.TABLE_NAME +
                        " ORDER BY " + DeepSpaceEntry.COLUMN_NAME_DATE + " DESC",
                null);

        if (cursor.moveToFirst()) {
            deepSpaceBean = new DeepSpaceBean();
            String date = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_DATE));
            String explanation = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_EXPLANATION));
            String title = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_TITLE));
            String hdurl = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_HDURL));
            String url = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_URL));
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

    public Observable<DeepSpaceBean> saveDP(final DeepSpaceBean deepSpaceBean) {
        return Observable
                .create(new Observable.OnSubscribe<DeepSpaceBean>() {
                    @Override
                    public void call(Subscriber<? super DeepSpaceBean> subscriber) {
                        DeepSpaceBean deepSpaceBean1 = null;
                        try {
                            deepSpaceBean1 = insertDP(deepSpaceBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_INSERT);
                            subscriber.onError(xiaohuException);
                        }
                        subscriber.onNext(deepSpaceBean1);
                        subscriber.onCompleted();
                    }
                });
    }

    public DeepSpaceBean insertDP(DeepSpaceBean deepSpaceBean) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.execSQL("insert into " + DeepSpaceEntry.TABLE_NAME +
                        "(" + DeepSpaceEntry.COLUMN_NAME_DATE +
                        ", " + DeepSpaceEntry.COLUMN_NAME_EXPLANATION +
                        ", " + DeepSpaceEntry.COLUMN_NAME_HDURL +
                        ", " + DeepSpaceEntry.COLUMN_NAME_TITLE +
                        ", " + DeepSpaceEntry.COLUMN_NAME_URL +
                        ")" +
                        " values(?,?,?,?,?)",
                new Object[]{deepSpaceBean.getDate(), deepSpaceBean.getExplanation(),
                        deepSpaceBean.getHdurl(), deepSpaceBean.getTitle(), deepSpaceBean.getUrl()});
//        db.close();
        return deepSpaceBean;
    }

    public Observable<Integer> deleteAllDPs() {
        return Observable
                .create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        Integer count = 0;
                        try {
                            SQLiteDatabase db = mDbHelper.getWritableDatabase();
                            count = db.delete(DeepSpaceEntry.TABLE_NAME, null, null);
//                            db.close();

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


    public Observable<Integer> deleteDP(final String date) {
        return Observable
                .create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        Integer count = 0;
                        try {
                            SQLiteDatabase db = mDbHelper.getWritableDatabase();
                            count = db.delete(DeepSpaceEntry.TABLE_NAME,
                                    DeepSpaceEntry.COLUMN_NAME_DATE + "=?",
                                    new String[]{String.valueOf(date)});
//                            db.close();
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
