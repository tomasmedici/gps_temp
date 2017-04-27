package com.example.gps_temp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by B004341 on 23-03-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME   = "kopholderManager";
    private static final String TABLE_KOPHOLDER = "kopholder";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_DIAMETER = "diameter";
    private static final String KEY_COLOUR = "colour";

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
    //addKopholder()
    //adding new kopholder(b,d,c)
    public void addKopholder(Kopholder kopholder) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_BRAND, kopholder.getBrand());
        values.put(KEY_DIAMETER, kopholder.getDiameter());
        values.put(KEY_COLOUR, kopholder.getColour());

        db.insert(TABLE_KOPHOLDER, null, values);  //inserting row
        db.close(); //closing database connection
    }
    //getKopholder()
    //getting single kopholder

    public Kopholder getKopholder(int brand) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_KOPHOLDER, new String[] { KEY_BRAND,
                        KEY_DIAMETER, KEY_COLOUR }, KEY_BRAND + "=?",
                new String[] { String.valueOf(brand) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Kopholder kopholder = new Kopholder(cursor.getString(0),
                Integer.parseInt(cursor.getString(1)), cursor.getString(2));
        // return kopholder
        return kopholder;
    }

    //getAllKopholder
    //getting all kopholder
    public List<Kopholder> getAllKopholder() {
        List<Kopholder> kopholderList = new ArrayList<Kopholder>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_KOPHOLDER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Kopholder kopholder = new Kopholder();
                kopholder.setBrand(cursor.getString(0));
                kopholder.setDiameter(Integer.parseInt(cursor.getString(1)));
                kopholder.setColour(cursor.getString(2));
                // Adding contact to list
                kopholderList.add(kopholder);
            } while (cursor.moveToNext());
        }

        // return contact list
        return kopholderList;
    }
    //Getting Kopholder count
    public int getKopholderCount() {
        String countQuery = "SELECT * FROM " + TABLE_KOPHOLDER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // Return count
        return cursor.getCount();
    }
    //Updating single Kopholder
    public int updateKopholder(Kopholder kopholder) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_BRAND, kopholder.getBrand());
        values.put(KEY_DIAMETER, kopholder.getDiameter());
        values.put(KEY_COLOUR, kopholder.getColour());

        // updating row
        return db.update(TABLE_KOPHOLDER, values, KEY_BRAND + " = ?",
                new String[] { String.valueOf(kopholder.getBrand()) });

    }
    //Deleting single Kopholder
    public void deleteKopholder(Kopholder kopholder) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_KOPHOLDER, KEY_BRAND + " = ?",
                new String[] {String.valueOf(kopholder.getBrand()) });
        db.close();

    }
}










