package ru.ifmo.md.colloquium3;

/**
 * Created by heat_wave on 23.12.14.
 */

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CurrencyTable {

    // Database table
    public static final String TABLE_CURRENCY = "currency";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_HAVING = "having";
    public static final String COLUMN_RATE = "rate";

    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_CURRENCY
            + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TYPE + " text not null, "
            + COLUMN_HAVING + " real not null,"
            + COLUMN_RATE
            + " real not null"
            + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        Log.w(CurrencyTable.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_CURRENCY);
        onCreate(database);
    }
}