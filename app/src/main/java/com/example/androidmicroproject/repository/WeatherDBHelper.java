package com.example.androidmicroproject.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WeatherDBHelper extends SQLiteOpenHelper {

    private static final String dbname = "WeatherDB";
    private static final int version =1;

    public WeatherDBHelper(Context context)
    {
        super(context, dbname ,null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String sql = "CREATE TABLE CITY_WT (_id INTEGER PRIMARY KEY AUTOINCREMENT, TEMPERATURE DOUBLE, HUMIDITY DOUBLE, CITY TEXT, STATE TEXT, COUNTRY TEXT, AQI FLOAT)";
    sqLiteDatabase.execSQL(sql);


    insertData("36.82","37","Pune","Maharashtra","India","107","WeatherDB");
    insertData("37.90","40","Mumbai","Maharashtra","India","102","WeatherDB");
    insertData("38.90","40","Hyderabad","Andhra Pradesh","India","102","WeatherDB");
    insertData("31.90","32","Sydney","Sydney","Australia","62","WeatherDB");
    insertData("32.90","30","New York","New York","USA","58","WeatherDB");


    }
    private void insertData(String temperature, String humidity, String city, String state, String country, String aqi, String database)
    {
        ContentValues values = new ContentValues();
        values.put("TEMPERATURE", temperature);
        values.put("HUMIDITY", humidity);
        values.put("CITY", city);
        values.put("STATE", state);
        values.put("COUNTRY", country);
        values.put("AQI", aqi);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
