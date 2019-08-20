package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowFactorialActivity extends AppCompatActivity {

    TextView rstTxt;
    TextView mltTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_factorial);

        rstTxt = (TextView)findViewById(R.id.rstTxt);
        mltTxt = (TextView)findViewById(R.id.mltTxt);

        int fct = getIntent().getIntExtra("fct",0);
        ArrayList<Integer> aux = fctList(fct);
        String mlt = mkStr(aux);
        mltTxt.setText(mlt);

        int rst = fctCalc(fct);
        rstTxt.setText("Resultado: "+Integer.toString(rst));

    }

    private ArrayList<Integer> fctList(int fct){
        ArrayList<Integer> out = new ArrayList<>();
        out.add(1);
        for(int i=1;i<fct;i++){
            out.add(i+1);
        }
        return out;
    }

    private String mkStr(ArrayList<Integer> arr){
        String s = "Multiplicacion: 1";
        for (int i=1;i<arr.size();i++){
            s = s  + "*" + arr.get(i);
        }
        return s;
    }

    private int fctCalc(int fct){
        int acum = 1;
        for (int i = 2; i <= fct; i++) {
            acum = acum * i;
        }
        return acum;
    }
}
