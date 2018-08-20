package com.cadhut.islamic.Quran16Line;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.cadhut.islamic.Quran16Line.MainActivity.ITEM;

public class MainPage extends AppCompatActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cadhut.islamic.Quran16Line.R.layout.intro_screen);






    }

    public void Resume(View v){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("Page_No",0);

        ITEM = pref.getInt("resume",558);

        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);


    }

    public void Page(View v){

        LayoutInflater layoutInflater =LayoutInflater.from(MainPage.this);

        final View view = layoutInflater.inflate(com.cadhut.islamic.Quran16Line.R.layout.dialog_box, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(MainPage.this).create();
        alertDialog.setCancelable(false);

        final EditText etComments = (EditText) view.findViewById(com.cadhut.islamic.Quran16Line.R.id.etComments);

        Button cancelButton =(Button)view.findViewById(com.cadhut.islamic.Quran16Line.R.id.cancel);
        Button goButton = (Button)view.findViewById(com.cadhut.islamic.Quran16Line.R.id.go);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               mGo(etComments);

            }
        });



        alertDialog.setView(view);
        alertDialog.show();

    }



    public void Juz(View v){

        Intent i = new Intent(getApplicationContext(),JuzContents.class);
        startActivity(i);
    }

    public void Surah(View v){

        Intent i = new Intent(getApplicationContext(),SuraContents.class);
        startActivity(i);

    }

    public void mGo(EditText ed){

        int page_no;
        int code_pg_no;
        int total =556;
        int converter;

       if(ed.getText().toString().equals("")){
           final AlertDialog error2 = new AlertDialog.Builder(MainPage.this, com.cadhut.islamic.Quran16Line.R.style.AlertDialogStyle).create();
           error2.setMessage("Please Enter a Page Number");
           error2.show();

       }else {

           page_no = Integer.parseInt(ed.getText().toString());


           if (page_no > 557 || page_no < 1) {
               final AlertDialog error = new AlertDialog.Builder(MainPage.this, com.cadhut.islamic.Quran16Line.R.style.AlertDialogStyle).create();
               error.setMessage("Please Enter a Valid Page Number");
               error.show();
           }else {

               converter = page_no-1;
               code_pg_no =total-converter;

               Intent i = new Intent(getApplicationContext(), MainActivity.class);
               ITEM =code_pg_no;
               startActivity(i);


           }



       }

    }




}
