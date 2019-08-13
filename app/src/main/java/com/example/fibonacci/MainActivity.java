package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button calcBtn;
    List<Integer> numbers;
    ScrollView scrlView;
    LinearLayout auxLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the list. Add the first 2 numbers to it.
        numbers = new ArrayList<Integer>();
        numbers.add(0);
        numbers.add(1);

        //Inflate TxtView and Btn
        scrlView = (ScrollView)findViewById(R.id.scrlView);
        auxLayout = (LinearLayout)findViewById(R.id.auxLayout);
        calcBtn = (Button)findViewById(R.id.btnCalc);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = (int) numbers.get(numbers.size()-1);
                int b = (int) numbers.get(numbers.size()-2);
                int termInt = a+b;
                numbers.add(termInt);
                String term = Integer.toString(termInt);
                TextView displayText = new TextView(auxLayout.getContext());
                displayText.setText(term);
                auxLayout.addView(displayText);
            }
        });
    }
}
