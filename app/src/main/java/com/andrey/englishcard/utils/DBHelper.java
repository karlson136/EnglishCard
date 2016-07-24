package com.andrey.englishcard.utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by andrey on 24.07.16.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "englishcard.db";
    public static final int DATABASE_VERSION = 1;

    public static DBHelper getInstance(Context context) {
        return new DBHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Dictionary.CREATE_DB_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Dictionary.DROP_DB_SQL);
        onCreate(sqLiteDatabase);
    }

    private static class Dictionary implements BaseColumns {
        private static final String DATABASE_TABLE = "Dictionary";

        public static final String ENGLISH_WORD = "englishWord";
        public static final String RUSSIAN_WORD = "russianhWord";

        private static final String CREATE_DB_SQL = String.format("create table %s ("
                + "%s integer primary key autoincrement, "
                + "%s text not null, "
                + "%s text not null);", DATABASE_TABLE, BaseColumns._ID, ENGLISH_WORD, RUSSIAN_WORD);

        public static final String DROP_DB_SQL = "DROP TABLE IF IT EXISTS " + DATABASE_TABLE;

    }

}
