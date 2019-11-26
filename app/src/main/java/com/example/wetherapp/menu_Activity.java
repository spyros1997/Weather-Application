package com.example.wetherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class menu_Activity extends AppCompatActivity {
   ImageView openweather, weatherbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       openweather = findViewById(R.id.imageView4);
       weatherbit = findViewById(R.id.imageView5);

        openweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_weather_activity();

            }
        });

        weatherbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherbit_activity();
            }
        });


    }

    public  void open_weather_activity(){
        new DbManager(this);
        Intent intent = new Intent(this, open_weather.class);
        startActivity(intent);
    }

    public  void weatherbit_activity(){
        new DbManager(this);
        Intent intent2 = new Intent(this, weatherbit.class);
        startActivity(intent2);
    }


}
