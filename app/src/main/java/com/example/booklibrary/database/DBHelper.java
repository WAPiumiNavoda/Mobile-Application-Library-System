package com.example.booklibrary.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {
    public static final String  DATABASE_NAME = "BookingLibrary.db";

    public static final String  TABLE_NAME = "MyLibrary";
    public static final String  COLUMN_ID = "_ID";
    public static final String  COLUMN_TITLE = "BookTitle";
    public static final String  COLUMN_AUTHOR = "BookAuthor";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String BOOKING_SCHEMA = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE + " TEXT, "
                + COLUMN_AUTHOR + " TEXT);" ;


      sqLiteDatabase.execSQL(BOOKING_SCHEMA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                        onCreate(sqLiteDatabase);
    }

    public long addbook(String bookname, String bookauthor){
           SQLiteDatabase sqLiteDatabase = getWritableDatabase();
           ContentValues  values = new ContentValues();

           values.put(COLUMN_TITLE, bookname);
           values.put(COLUMN_AUTHOR, bookauthor);

        return sqLiteDatabase.insert(TABLE_NAME,null,values);
    }

    public Cursor readAllbooks(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = null;
        if(sqLiteDatabase != null){
            sqLiteDatabase.rawQuery(query, null);
        }
        return cursor;
    }

    public ArrayList readAllBookList(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                COLUMN_TITLE,
                COLUMN_AUTHOR
        };

        String selection = COLUMN_AUTHOR + " =?" + COLUMN_TITLE + " =?";

        //String title = "piumi";
       //String[] selectionArgs = { title };

        String sortOrder = COLUMN_AUTHOR + " ASC";

        Cursor cursor = sqLiteDatabase.query(
                TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        ArrayList tiltleList=  new ArrayList<>();

        while (cursor.moveToNext()){
            String titleA =cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));


            tiltleList.add(titleA);

        }
        cursor.close();
        return tiltleList;
    }
}
