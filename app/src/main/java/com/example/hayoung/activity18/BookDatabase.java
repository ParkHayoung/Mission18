package com.example.hayoung.activity18;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by hayoung on 2017. 8. 17..
 */

public class BookDatabase {

    private static BookDatabase database;

    public static String DATABASE_NAME = "book.db";
    public static String TABLE_NAME = "book_info";
    public static int DATABASE_VERSION = 1;

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static synchronized BookDatabase getInstance() {
        if (database == null) {
            database = new BookDatabase();
        }

        return database;
    }

    public boolean open(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();

        return true;
    }

    public void close() {
        db.close();
        database = null;
    }

    public Cursor rawQuery(String SQL) {
        Cursor c1 = null;

        try {
            c1 = db.rawQuery(SQL, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return c1;
    }

    public boolean execSQL(String SQL) {
        try {
            db.execSQL(SQL);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public void insertRecord(String name, String author, String content) {
        try {
            db.execSQL("insert into " + TABLE_NAME + "(name, author, content) "
                    + "values ('" + name + "', '" + author + "', '" + content + "');");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<BookInfo> selectAll() {
        ArrayList<BookInfo> result = new ArrayList<>();

        try {
            Cursor cursor = db.rawQuery("select name, author, content, from " + TABLE_NAME, null);
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                String name = cursor.getString(0);
                String author = cursor.getString(1);
                String content = cursor.getString(2);

                BookInfo info = new BookInfo(name, author, content);
                result.add(info);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }




    public class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String DROP_SQL = "drop table if exists " + TABLE_NAME;
            try {
                db.execSQL(DROP_SQL);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            String CREATE_SQL = "create table " + TABLE_NAME + "("
                    + "_id integer PRIMARY KEY autoincrement, "
                    + "name text, "
                    + "author text, "
                    + "content text)";

            try {
                db.execSQL(CREATE_SQL);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }




    }

}
