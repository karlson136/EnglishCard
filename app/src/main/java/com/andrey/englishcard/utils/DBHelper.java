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
        sqLiteDatabase.execSQL(Dictionary.CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Dictionary.DROP_TABLE_SQL);
        onCreate(sqLiteDatabase);
    }

    public static class Dictionary implements BaseColumns {
        private static final String TABLE_NAME = "Dictionary";

        public static final String ENGLISH_WORD = "englishWord";
        public static final String RUSSIAN_WORD = "russianWord";
        public static final String LEARNED = "learned";

        private static final String CREATE_TABLE_SQL = "create table " + TABLE_NAME + " ("
                + _ID + " integer primary key autoincrement, "
                + ENGLISH_WORD + " text not null, "
                + RUSSIAN_WORD + " text not null, "
                + LEARNED + " integer not null default 0)";

        public static final String DROP_TABLE_SQL = "drop table if it exists " + TABLE_NAME;

        public static final String INSERT_TABLE_SQL = "insert into " + TABLE_NAME + "("
                + ENGLISH_WORD + ", " + RUSSIAN_WORD + ") "
                + "values ('%s', '%s')";

        public static String insert(String englishWord, String russianWord) {
            return String.format(INSERT_TABLE_SQL, englishWord, russianWord);
        }
    }

}
