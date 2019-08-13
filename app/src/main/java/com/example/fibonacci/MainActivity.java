package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    Button calcBtn;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Inflate Layout and Button
        editText = (EditText)findViewById(R.id.nbrTrms);
        calcBtn = (Button)findViewById(R.id.btnCalc);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nbrTrms = Integer.parseInt(editText.getText().toString());
                Intent intent = new Intent(calcBtn.getContext(), ShowTermsActivity.class);
                intent.putExtra("nbrTrms", nbrTrms);
                startActivity(intent);


            }
        });
    }
}
