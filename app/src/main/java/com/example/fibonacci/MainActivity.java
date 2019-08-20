package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class MainActivity extends AppCompatActivity {


    Button calcBtn;
    Button cntBtn;
    Button fctBtn;
    ImageButton imgBtn;
    EditText editText;
    Spinner spinner;
    int countFib;
    int countFac;
    TextView cntrFib;
    TextView cntrFac;
    TextView dtFib;
    TextView dtFac;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cntrFac = (TextView)findViewById(R.id.cntrFac);
        cntrFib = (TextView)findViewById(R.id.cntrFib);
        dtFac = (TextView)findViewById(R.id.dtFac);
        dtFib = (TextView)findViewById(R.id.dtFib);
        countFac = 0;
        countFib = 0;
        //Inflate Layout and Button
        editText = (EditText)findViewById(R.id.nbrTrms);
        spinner = (Spinner)findViewById(R.id.spinner);
        calcBtn = (Button)findViewById(R.id.btnCalc);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countFib++;
                cntrFib.setText(Integer.toString(countFib));
                dtFib.setText(dtf.format(LocalDateTime.now()));
                int nbrTrms = Integer.parseInt(editText.getText().toString());
                Intent intent = new Intent(calcBtn.getContext(), ShowTermsActivity.class);
                intent.putExtra("nbrTrms", nbrTrms);
                startActivity(intent);


            }
        });

        cntBtn = (Button)findViewById(R.id.cntBtn);
        cntBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cntBtn.getContext(), ShowCountriesActivity.class);
                startActivity(intent);
            }
        });

        imgBtn = (ImageButton)findViewById(R.id.imgBtn);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(imgBtn.getContext(), ShowWebPageActivity.class);
                intent.putExtra("link","https://es.wikipedia.org/wiki/Leonardo_de_Pisa");
                startActivity(intent);
            }
        });

        fctBtn = (Button)findViewById(R.id.fctBtn);
        fctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countFac++;
                cntrFac.setText(Integer.toString(countFac));
                dtFac.setText(dtf.format(LocalDateTime.now()));
                int fct = Integer.parseInt((String) spinner.getSelectedItem());
                Intent intent = new Intent(fctBtn.getContext(),ShowFactorialActivity.class);
                intent.putExtra("fct",fct);
                startActivity(intent);
            }
        });



    }
}



