package com.example.wetherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class History_Activity extends AppCompatActivity {
    TextView date , status , min_temp , max_temp , temp , test , datetxt ,data;
    Button search;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    ListView  datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listItem = new ArrayList<>();

      //  date = findViewById(R.id.date_text);
        //status = findViewById(R.id.status_text);
       // min_temp= findViewById(R.id.mint_text);
      //  max_temp = findViewById(R.id.maxt_text);
      //  temp = findViewById(R.id.temp_text);
        search = findViewById(R.id.search);
        //test = findViewById(R.id.test);
        datetxt = findViewById(R.id.datetxt);
        //data = findViewById(R.id.data);
        datalist = findViewById(R.id.datalist);

        data_return();




       search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

    }

    public void data_return(){
        DbManager db2 = new DbManager(this);
        Cursor cursor = db2.ViewData();

        if(cursor.getCount() == 0){
            Toast.makeText(this,"Δεν βρέθηκαν δεδομένα",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+cursor.getString(4)+"\n"+cursor.getString(5)+"\n\n");
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            datalist.setAdapter(adapter);

        }



      //  StringBuilder stringBuilder = new StringBuilder();

     //   while (cursor.moveToNext()){



        //   stringBuilder.append("Θερμοκρασία: "+cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+cursor.getString(4)+"\n"+cursor.getString(5)+"\n"+"\n"+"\n"+"\n");


       // }
       // data.setText(stringBuilder);


    }
}
