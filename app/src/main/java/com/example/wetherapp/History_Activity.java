package com.example.wetherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class History_Activity extends AppCompatActivity {
    TextView date , status , min_temp , max_temp , temp , test , datetxt ,data;
    EditText edittext;
    Button search;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    ListView  datalist;
    String[] items;

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
        //search = findViewById(R.id.search);
        //test = findViewById(R.id.test);
       // datetxt = findViewById(R.id.datetxt);
        //data = findViewById(R.id.data);
        datalist = findViewById(R.id.datalist);
        edittext = findViewById(R.id.editText);

        items = new String[]{"15/11/2019"};
        datalist.setTextFilterEnabled(true);

        data_return();


        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                History_Activity.this.adapter.getFilter().filter(s);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

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
                listItem.add("Θερμοκρασία: "+cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+cursor.getString(4)+"\n"+cursor.getString(5)+"\n"+"Πόλη: "+cursor.getString(6)+"\n");
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
