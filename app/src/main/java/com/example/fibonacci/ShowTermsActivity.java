package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowTermsActivity extends AppCompatActivity {

    List<Integer> numbers;
    LinearLayout auxLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_terms);

        Intent intent = getIntent();
        int nbrTrms = intent.getIntExtra("nbrTrms",0);
        //Create the list. Add the first 2 numbers to it.
        numbers = new ArrayList<Integer>();
        numbers.add(0);
        numbers.add(1);


        auxLayout = (LinearLayout)findViewById(R.id.auxScrlLyt);

        //Logic for FIB
        for(int i = 0; i<nbrTrms; i++){
            int a = (int) numbers.get(numbers.size()-1);
            int b = (int) numbers.get(numbers.size()-2);
            int termInt = a+b;
            numbers.add(termInt);
            String term = Integer.toString(termInt);
            //Logic to display the new calculated term
            TextView displayText = new TextView(auxLayout.getContext());
            displayText.setText(term);
            auxLayout.addView(displayText);
        }

    }
}
