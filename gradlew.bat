package com.example.datepicker1;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText date;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiate the date picker and a button
        date=findViewById(R.id.date);

        // perform click vent on edit text

        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // instanciate calender class , and get current date , month and uear from calender
                final Calendar c= Calendar.getInstance();
                int mYear=c.get(Calendar.YEAR);  //current Year
                int  mMonth= c.get(Calendar.MONTH); // current month
                int mDay= c.get(Calendar.DAY_OF_MONTH); // current day


                // date picker dialog

                datePickerDialog=new  DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                    {
                        date.setText((dayOfMonth+"/"+(month+1)+"/"+year));
                    }
                },mYear,mMonth,mDay);


                datePickerDialog.show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch(item.getItemId())
        {
        