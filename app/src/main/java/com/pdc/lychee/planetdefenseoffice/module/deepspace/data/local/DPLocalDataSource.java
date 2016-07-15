package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote.DPRemoteDataSource;
import com.pdc.lychee.planetdefenseoffice.retrofit.XIAOHUException;

import java.util.List;

import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import pdo.deepspace.DP;
import pdo.deepspace.DPDao;
import pdo.deepspace.DaoMaster;
import pdo.deepspace.DaoSession;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by lychee on 2016/6/23.
 */
public class DPLocalDataSource {
    private volatile static DPLocalDataSource INSTANCE;

    //    private DPDBHelper mDbHelper;
    private DPDao dpDao;

    private DPLocalDataSource(Context context) {
//        mDbHelper = new DPDBHelper(context);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "PDO.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        dpDao = daoSession.getDPDao();
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
                            if (deepSpaceBean != null) {
                                subscriber.onNext(deepSpaceBean);
                            }
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
                            if (deepSpaceBean != null) {
                                subscriber.onNext(deepSpaceBean);
                            }
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
        QueryBuilder<DP> qb = dpDao.queryBuilder();
        DeepSpaceBean deepSpaceBean = null;
        Query<DP> build = qb.where(DPDao.Properties.Date.eq(mDate)).build();
        List<DP> dps = build.list();
        if (dps != null && dps.size() > 0) {
            deepSpaceBean = new DeepSpaceBean();
            DP dp = dps.get(0);
            deepSpaceBean.setDate(dp.getDate());
            deepSpaceBean.setExplanation(dp.getExplanation());
            deepSpaceBean.setTitle(dp.getTitle());
            deepSpaceBean.setHdurl(dp.getHdurl());
            deepSpaceBean.setUrl(dp.getUrl());
            deepSpaceBean.setMediaType(dp.getMedia_type());
        }
//        SQLiteDatabase db = mDbHelper.getWritableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " +
//                DeepSpaceEntry.TABLE_NAME +
//                " where " + DeepSpaceEntry.COLUMN_NAME_DATE + "=?", new String[]{String.valueOf(mDate)});
//
//        if (cursor.moveToNext()) {
//            deepSpaceBean = new DeepSpaceBean();
//            String date = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_DATE));
//            String explanation = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_EXPLANATION));
//            String title = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_TITLE));
//            String hdurl = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_HDURL));
//            String url = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_URL));
//            String mediatype = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_MEDIATYPE));
//            deepSpaceBean.setDate(date);
//            deepSpaceBean.setExplanation(explanation);
//            deepSpaceBean.setTitle(title);
//            deepSpaceBean.setHdurl(hdurl);
//            deepSpaceBean.setUrl(url);
//            deepSpaceBean.setMediaType(mediatype);
//        }
//        cursor.close();
//        db.close();
        return deepSpaceBean;
    }

    private DeepSpaceBean queryDP() throws Exception {
        DeepSpaceBean deepSpaceBean = null;
        List<DP> dps = dpDao.loadAll();
        if (dps != null && dps.size() > 0) {
            deepSpaceBean = new DeepSpaceBean();
            DP dp = dps.get(0);
            deepSpaceBean.setDate(dp.getDate());
            deepSpaceBean.setExplanation(dp.getExplanation());
            deepSpaceBean.setTitle(dp.getTitle());
            deepSpaceBean.setHdurl(dp.getHdurl());
            deepSpaceBean.setUrl(dp.getUrl());
            deepSpaceBean.setMediaType(dp.getMedia_type());
        }
//        DeepSpaceBean deepSpaceBean = null;
//        SQLiteDatabase db = mDbHelper.getWritableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " + DeepSpaceEntry.TABLE_NAME +
//                        " ORDER BY " + DeepSpaceEntry.COLUMN_NAME_DATE + " DESC LIMIT " + 1,
//                null);
//
//        if (cursor.moveToFirst()) {
//            deepSpaceBean = new DeepSpaceBean();
//            String date = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_DATE));
//            String explanation = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_EXPLANATION));
//            String title = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_TITLE));
//            String hdurl = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_HDURL));
//            String url = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_URL));
//            String mediatype = cursor.getString(cursor.getColumnIndex(DeepSpaceEntry.COLUMN_NAME_MEDIATYPE));
//            deepSpaceBean.setDate(date);
//            deepSpaceBean.setExplanation(explanation);
//            deepSpaceBean.setTitle(title);
//            deepSpaceBean.setHdurl(hdurl);
//            deepSpaceBean.setUrl(url);
//            deepSpaceBean.setMediaType(mediatype);
//        }
//        cursor.close();
//        db.close();
        return deepSpaceBean;
    }

    public Observable<DeepSpaceBean> saveDP(final DeepSpaceBean deepSpaceBean) {
        return Observable
                .create(new Observable.OnSubscribe<DeepSpaceBean>() {
                    @Override
                    public void call(Subscriber<? super DeepSpaceBean> subscriber) {
                        try {
                            subscriber.onNext(insertDP(deepSpaceBean));
                            subscriber.onCompleted();
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_INSERT);
                            subscriber.onError(xiaohuException);
                        }
                    }
                });
    }

    public DeepSpaceBean insertDP(DeepSpaceBean dsp) {
        DP dp = new DP(null, dsp.getDate(), dsp.getExplanation(), dsp.getHdurl(), dsp.getTitle(), dsp.getUrl(), dsp.getMediaType());
        dpDao.insertOrReplace(dp);
//        SQLiteDatabase db = mDbHelper.getWritableDatabase();
//        db.execSQL("insert into " + DeepSpaceEntry.TABLE_NAME +
//                        "(" + DeepSpaceEntry.COLUMN_NAME_DATE +
//                        ", " + DeepSpaceEntry.COLUMN_NAME_EXPLANATION +
//                        ", " + DeepSpaceEntry.COLUMN_NAME_HDURL +
//                        ", " + DeepSpaceEntry.COLUMN_NAME_TITLE +
//                        ", " + DeepSpaceEntry.COLUMN_NAME_URL +
//                        ", " + DeepSpaceEntry.COLUMN_NAME_MEDIATYPE +
//                        ")" +
//                        " values(?,?,?,?,?,?)",
//                new Object[]{deepSpaceBean.getDate(), deepSpaceBean.getExplanation(),
//                        deepSpaceBean.getHdurl(), deepSpaceBean.getTitle(),
//                        deepSpaceBean.getUrl(), deepSpaceBean.getMediaType()});
//        db.close();
        return dsp;
    }

    public Observable<Integer> deleteAllDPs() {
        return Observable
                .create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        Integer count = 0;
                        try {
//                            SQLiteDatabase db = mDbHelper.getWritableDatabase();
//                            count = db.delete(DeepSpaceEntry.TABLE_NAME, null, null);

                            dpDao.deleteAll();

                            subscriber.onNext(count);
                            subscriber.onCompleted();
//                            db.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_DELETE);
                            subscriber.onError(xiaohuException);
                        }

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
//                            SQLiteDatabase db = mDbHelper.getWritableDatabase();
//                            count = db.delete(DeepSpaceEntry.TABLE_NAME,
//                                    DeepSpaceEntry.COLUMN_NAME_DATE + "=?",
//                                    new String[]{String.valueOf(date)});

                            QueryBuilder<DP> qb = dpDao.queryBuilder();
                            DeleteQuery<DP> bd = qb.where(DPDao.Properties.Date.eq(date)).buildDelete();
                            bd.executeDeleteWithoutDetachingEntities();

                            subscriber.onNext(count);
                            subscriber.onCompleted();

//                            db.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            XIAOHUException xiaohuException = new XIAOHUException(e, XIAOHUException.DB_DELETE);
                            subscriber.onError(xiaohuException);
                        }

                    }
                });
    }
}
