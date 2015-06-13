package com.pe.asistente.deportivo.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JorgeLuis on 13/06/2015.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private String strCreateTableEstadisticaIMC = "CREATE TABLE IF NOT EXISTS imc_estadistica (id INTEGER PRIMARY KEY AUTOINCREMENT, peso TEXT, estatura TEXT, imc TEXT, fecha TEXT)";

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(strCreateTableEstadisticaIMC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
