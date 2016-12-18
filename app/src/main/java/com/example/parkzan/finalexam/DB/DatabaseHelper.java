package com.example.parkzan.finalexam.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.parkzan.finalexam.UserListActivity;
import com.example.parkzan.finalexam.adapter.UserListAdapter;

/**
 * Created by ParkZan on 12/18/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
  private  SQLiteDatabase mdb;
    private static final String DATABASE_NAME = "Losgin";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_NAME = "LOGIN";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_UserNAME= "userNAme";
    public static final String COL_PASS= "col_pass";

    private static final String SQL_CRATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_UserNAME + " TEXT, "
                    + COL_PASS +" TEXT"
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
       db.execSQL(SQL_CRATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "Android Studio");
        cv.put(COL_UserNAME, "android");
        cv.put(COL_PASS, "123456");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");

        onCreate(_db);
    }
    public  DatabaseHelper open() throws SQLException
    {
        mdb = getWritableDatabase();
        return this;
    }

    public String getSinlgeEntry(String userName) {
        Cursor cursor= mdb.query(TABLE_NAME, null," userNAme=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("col_pass"));
        cursor.close();
        return password;
    }
}
