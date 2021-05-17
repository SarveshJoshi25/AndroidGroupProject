package com.example.androidmicroproject.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidmicroproject.model.Cloudiness;
import com.example.androidmicroproject.model.Temperature;
import com.example.androidmicroproject.model.Weather;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class WeatherDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "WeatherDB.db";
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
                /*date_of_entry and city are primary keys*/
                "date_of_entry text, " +
                "city text, " +
                "temp_min double not null, " +
                "temp_max double not null, " +
                "temp_current double not null, " +
                "humidity double not null, " +
                "state text not null, " +
                "country text not null, " +
                "sunrise_time text not null, " +
                "sunset_time text not null, " +
                "air_quality_index int not null," +
                "primary key(date_of_entry, city)" +
                ")";

        sqLiteDatabase.execSQL(sql);
    }

    private void insertDummyData() {
        set(firstRow, new GregorianCalendar(2021, 5, 16));

        set(
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
                ),
                new GregorianCalendar(2021, 5, 17)
        );
        set(
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
                ),
                new GregorianCalendar(2021, 5, 18)
        );

        try (Cursor cur = getReadableDatabase().rawQuery("select * from " + TABLE, new String[]{})) {
            assert (cur.getCount() > 0);
        }
    }

    public void set(Weather weather, GregorianCalendar date) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE, "city = ? and date_of_entry = ?", new String[]{weather.city, format(date)});
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

        values.put("date_of_entry", format(date));

        db.insert(TABLE, null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    private static String format(GregorianCalendar calendar) {
        final SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }
}