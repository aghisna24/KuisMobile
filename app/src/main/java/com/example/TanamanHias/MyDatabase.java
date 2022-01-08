package com.example.TanamanHias;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_tanaman";
    private static final String tb_tanaman = "tb_tanaman";
    private static final String tb_tanaman_id = "id";
    private static final String tb_tanaman_nama = "nama";
    private static final String tb_tanaman_tipe = "tipe";
    private static final String CREATE_TABLE_tanaman = "CREATE TABLE " +
    tb_tanaman +"("
            + tb_tanaman_id + " INTEGER PRIMARY KEY ,"
            + tb_tanaman_nama + " TEXT ,"
            + tb_tanaman_tipe + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_tanaman);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateTanaman(Tanaman data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tanaman_id, data.get_id());
        values.put(tb_tanaman_nama, data.get_nama());
        values.put(tb_tanaman_tipe, data.get_tipe());
        db.insert(tb_tanaman, null, values);
        db.close();
    }
    public List<Tanaman> ReadTanaman() {
        List<Tanaman> listMhs = new ArrayList<Tanaman>();
        String selectQuery = "SELECT * FROM " + tb_tanaman;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Tanaman data = new Tanaman();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_tipe(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;}
    public int UpdateTanaman (Tanaman data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tanaman_nama, data.get_nama());
        values.put(tb_tanaman_tipe, data.get_tipe());
        return db.update(tb_tanaman, values, tb_tanaman_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteTanaman(Tanaman data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_tanaman,tb_tanaman_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
