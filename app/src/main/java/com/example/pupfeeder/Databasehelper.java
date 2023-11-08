package com.example.pupfeeder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "pupfeeder";
    private static int VERSA0=1;

    public Databasehelper(Context context){
        super(context, BANCO_DADOS,null, VERSA0);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE racoes (_id INTEGER PRIMARY KEY,marca TEXT, quantidade INTEGER, tipo Text,porte Text)");
    }

    @Override

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }



}
