package com.example.parkzan.finalexam.User;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.parkzan.finalexam.DB.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by ParkZan on 12/18/2016.
 */

public class UserDB {
    private static UserDB mInstance;
    private Context mContext;
    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private ArrayList<User> mUserList = new ArrayList<>();



    public static UserDB getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new UserDB(context);
        }
        return mInstance;
    }
    public UserDB(Context context) {
        this.mContext = context;
    }

    public void loadFromDatabase() {
        mUserList.clear();
        mHelper = new DatabaseHelper(mContext);
        mDb = mHelper.getWritableDatabase();
        Cursor cursor = mDb.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
            String user_name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_UserNAME));
            String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASS));


            User user = new User(name, user_name,password);
            mUserList.add(user);
        }
        cursor.close();
        //mDb.close();
        //mHelper.close();
    }
    public ArrayList<User> getUserList() {

        return mUserList;
    }

}
