package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {


    Button calcBtn;
    Button cntBtn;
    ImageButton imgBtn;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inflate Layout and Button
        editText = (EditText)findViewById(R.id.nbrTrms);
        calcBtn = (Button)findViewById(R.id.cntBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
    }
}
