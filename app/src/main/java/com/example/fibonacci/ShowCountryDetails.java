package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowCountryDetails extends AppCompatActivity {

    TextView name;
    TextView int_name;
    TextView capital;
    TextView code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_country_details);

        Bundle bundle = getIntent().getBundleExtra("bundle");
        String nameS = bundle.getString("name");
        String int_nameS = bundle.getString("int_name");
        String capitalS = bundle.getString("capital");
        String codeS = bundle.getString("code");

        name = (TextView)findViewById(R.id.name);
        int_name = (TextView)findViewById(R.id.int_name);
        capital = (TextView)findViewById(R.id.cap);
        code = (TextView)findViewById(R.id.code);

        name.setText(nameS);
        int_name.setText(int_nameS);
        capital.setText(capitalS);
        code.setText(codeS);
    }
}
