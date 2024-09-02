package com.example.edonator.ui.Login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "edonate.db";
    private static final int DATABASE_VERSION = 1;

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + "users" + " (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "full_name TEXT, " +
                "gender TEXT, " +
                "mobile_number INT, " +
                "address TEXT, " +
                "sub_county TEXT, " +
                "email TEXT, " +
                "password TEXT, " +
                "donor BOOLEAN);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "table_name");
        onCreate(db);
    }
}

