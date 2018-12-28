package com.example.mark.logreg;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="Felhasznalo.db";
    public static final String TABLE_NAME ="Felhasznalo_tabla";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "FELHASZNALONEV";
    public static final String COL_3 = "JELSZO";
    public static final String COL_4 = "MEGEROSITO";
    public static final String COL_5 = "TELJESNEVED";
    public static final String COL_6 = "TELEFONSZAM";

    public DB(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "FELHASZNALONEV TEXT,JELSZO TEXT,MEGEROSITO TEXT,TELJESNEVED TEXT,TELEFONSZAM TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean adatRogzites (String fnev,String jszo,String jmegerosit,String tnev,String tszam) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, fnev);
        contentValues.put(COL_3, jszo);
        contentValues.put(COL_4, jmegerosit);
        contentValues.put(COL_5, tnev);
        contentValues.put(COL_6, tszam);

        long eredmeny = db.insert(TABLE_NAME, null, contentValues);
        if (eredmeny == -1) {
            return false;
        } else
        {
            return true;
        }

    }

    public Cursor adatLekerdezes()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor eredmeny = db.rawQuery(" SELECT FELHASZNALONEV,JELSZO FROM "+TABLE_NAME,null);
        return eredmeny;
    }
}
