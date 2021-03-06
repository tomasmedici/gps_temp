package com.example.gps_temp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatDialogFragment;

/**
 * Created by B004341 on 23-03-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME   = "kopholderManager";
    private static final String TABLE_KOPHOLDER = "kopholder";
    private static final String KEY_BRAND = "brand";_
    private static final String KEY_DIAMETER = "diameter";_
    private static final String KEY_COLOUR = "colour";_

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_KOPHOLDER_TABLE =
                "CREATE TABLE " + TABLE_KOPHOLDER +
                        "(" + KEY_BRAND +
                        " INTEGER PRIMARY KEY," + KEY_DIAMETER +
                        " TEXT," + KEY_COLOUR +
                        " TEXT" + ")";
        db.execSQL(CREATE_KOPHOLDER_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KOPHOLDER);
        onCreate(db);
    }
    //adding new kopholder(b,d,c)
    public void addKopholder(Kopholder kopholder) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_BRAND, kopholder.getBrand());
        values.put(KEY_DIAMETER, kopholder.getDiameter());
        values.put(KEY_COLOUR, kopholder.getColour());
        //inserting row
        db.insert(TABLE_KOPHOLDER, null, values);
        db.close(); //closing database connection
    }
    //getting single kopholder
    public Kopholder getKopholder(String brand) {
        SQLiteDatabase db = this.getReadableDatabase();


    }
}










