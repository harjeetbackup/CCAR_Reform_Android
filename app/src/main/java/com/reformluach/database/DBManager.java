package com.reformluach.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String eventsname, String day, String month, String year) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.EVENTSNAME, eventsname);
        contentValue.put(DatabaseHelper.DAY, day);
        contentValue.put(DatabaseHelper.MONTH, month);
        contentValue.put(DatabaseHelper.YEAR, year);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[]{DatabaseHelper._ID, DatabaseHelper.EVENTSNAME, DatabaseHelper.DAY, DatabaseHelper.MONTH, DatabaseHelper.YEAR};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String eventsname, String day, String month, String year) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.EVENTSNAME, eventsname);
        contentValues.put(DatabaseHelper.DAY, day);
        contentValues.put(DatabaseHelper.MONTH, month);
        contentValues.put(DatabaseHelper.YEAR, year);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
  /*  public Cursor getAllPersons() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + PERSON_TABLE_NAME, null );
        return res;
    }*/
}