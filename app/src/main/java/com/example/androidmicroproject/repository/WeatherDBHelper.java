package com.example.androidmicroproject.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidmicroproject.model.Cloudiness;
import com.example.androidmicroproject.model.Temperature;
import com.example.androidmicroproject.model.Weather;

import java.util.GregorianCalendar;

public class WeatherDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "WeatherDB";
    public static final String TABLE = "weather";

    public WeatherDBHelper(Context context) {
        super(context, DATABASE, null, 1);
        getReadableDatabase();
        insertDummyData();
    }

    public static final Weather firstRow = new Weather(
            new Temperature(28, 37, 32),
            107,
            "Pune",
            "Maharashtra",
            "India",
            new GregorianCalendar(2021, 5, 16, 5, 30),
            new GregorianCalendar(2021, 5, 16, 17, 30),
            100,
            Cloudiness.Cloudy
    );

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE + " (" +
                "date_of_entry text primary key, " +
                "temp_min double, " +
                "temp_max double, " +
                "temp_current double, " +
                "humidity double, " +
                "city text, " +
                "state text, " +
                "country text, " +
                "sunrise_time text, " +
                "sunset_time text, " +
                "air_quality_index int" +
                ")";

        sqLiteDatabase.execSQL(sql);


        /*insertData("36.82", "37", "Pune", "Maharashtra", "India", "107", "WeatherDB");
        insertData("37.90", "40", "Mumbai", "Maharashtra", "India", "102", "WeatherDB");
        insertData("38.90", "40", "Hyderabad", "Andhra Pradesh", "India", "102", "WeatherDB");
        insertData("31.90", "32", "Sydney", "Sydney", "Australia", "62", "WeatherDB");
        insertData("32.90", "30", "New York", "New York", "USA", "58", "WeatherDB");*/
    }

    private void insertDummyData() {
        insert(firstRow);

        insert(
                new Weather(
                        new Temperature(28, 37, 32),
                        110,
                        "Pune",
                        "Maharashtra",
                        "India",
                        new GregorianCalendar(2021, 5, 17, 5, 30),
                        new GregorianCalendar(2021, 5, 17, 17, 30),
                        90,
                        Cloudiness.Cloudy
                )
        );
        insert(
                new Weather(
                        new Temperature(28, 37, 32),
                        130,
                        "Pune",
                        "Maharashtra",
                        "India",
                        new GregorianCalendar(2021, 5, 16, 5, 30),
                        new GregorianCalendar(2021, 5, 16, 17, 30),
                        100,
                        Cloudiness.Cloudy
                )
        );

        try (Cursor cur = getReadableDatabase().rawQuery("select * from " + TABLE, new String[]{})) {
            assert (cur.getCount() > 0);
        }
    }

    public void insert(Weather weather) {
        ContentValues values = new ContentValues();
        values.put("temp_min", weather.temperature.min);
        values.put("temp_max", weather.temperature.max);
        values.put("temp_current", weather.temperature.current);

        values.put("humidity", weather.humidity);

        values.put("city", weather.city);
        values.put("state", weather.state);
        values.put("country", weather.country);

        values.put("sunrise_time", weather.sunriseTime.toString());
        values.put("sunset_time", weather.sunsetTime.toString());

        getWritableDatabase().insert(TABLE, null, values);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
