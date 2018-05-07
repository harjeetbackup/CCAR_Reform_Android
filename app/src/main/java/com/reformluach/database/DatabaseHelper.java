package com.reformluach.database;
/**
 * Created by Naveen Mishra on 12/11/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Table Name
    public static final String TABLE_NAME = "EVENTSLIST";
    // Table columns
    public static final String _ID = "_id";
    public static final String SUBJECT = "subject";
    public static final String DESC = "description";
    public static final String EVENTSNAME = "eventname";
    public static final String DAY = "day";
    public static final String MONTH = "month";
    public static final String YEAR = "year";
    // Database Information
    static final String DB_NAME = "EVENTSLIST.DB";
    // database version
    static final int DB_VERSION = 1;
    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EVENTSNAME + " TEXT NOT NULL, " + DAY + " TEXT NOT NULL, " + MONTH + " TEXT NOT NULL, " + YEAR + " NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
