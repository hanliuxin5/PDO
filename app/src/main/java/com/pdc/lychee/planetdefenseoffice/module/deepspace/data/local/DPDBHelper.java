package com.pdc.lychee.planetdefenseoffice.module.deepspace.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pdc.lychee.planetdefenseoffice.utils.LogUtil;

/**
 * Created by lychee on 2016/6/23.
 */
public class DPDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "PDO.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String SQL_CREATE_DEEPSPACE =
            "CREATE TABLE " + DeepSpacePersistenceContract.DeepSpaceEntry.TABLE_NAME + " (" +
                    DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_DATE + TEXT_TYPE + "PRIMARY KEY," +
                    DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_EXPLANATION + TEXT_TYPE + "," +
                    DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_HDURL + TEXT_TYPE + "," +
                    DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_TITLE + TEXT_TYPE + "," +
                    DeepSpacePersistenceContract.DeepSpaceEntry.COLUMN_NAME_URL +
                    " )";

    public DPDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        LogUtil.i("DPDBHelper---onCreate");
        db.execSQL(SQL_CREATE_DEEPSPACE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
        LogUtil.i("DPDBHelper---onUpgrade");
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
        LogUtil.i("DPDBHelper---onDowngrade");
    }
}
