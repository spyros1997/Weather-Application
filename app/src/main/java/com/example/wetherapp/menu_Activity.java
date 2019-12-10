package com.example.wetherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class menu_Activity extends AppCompatActivity {
   ImageView openweather, accu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       openweather = findViewById(R.id.imageView4);
       accu = findViewById(R.id.accu);

        openweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_weather_activity();

            }
        });


        accu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accuweather_activity();

            }
        });


    }

    public  void open_weather_activity(){
        new DbManager(this);
        Intent intent = new Intent(this, open_weather.class);
        startActivity(intent);
    }


    public  void accuweather_activity(){
        new DbManager(this);
        Intent intent3 = new Intent(this, Accuweather.class);
        startActivity(intent3);
    }


}
