package ru.ifmo.md.colloquium3;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by heat_wave on 23.12.14.
 */
public class CurrencyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "currencytable.db";
    private static final int DATABASE_VERSION = 1;

    public CurrencyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        CurrencyTable.onCreate(database);
    }

    // Method is called during an upgrade of the database,
    // e.g. if you increase the database version
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
                          int newVersion) {
        CurrencyTable.onUpgrade(database, oldVersion, newVersion);
    }


}
