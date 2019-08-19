package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowCountriesActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Country> cts = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_countries);

        initArray();
        final String[] names = this.contriesNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        listView = (ListView) findViewById(R.id.lstVw);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cnt = names[i];
                Map<String,Country> aux = toMap(cts);
                Country c = aux.get(cnt);
                Intent intent = new Intent(getBaseContext(),ShowCountryDetails.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",c.getName());
                bundle.putString("capital",c.getCapital());
                bundle.putString("int_name",c.getInt_name());
                bundle.putString("code",c.getCode());
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });

    }


    private Map<String,Country> toMap(ArrayList<Country> arr){
        Map<String,Country> map = new HashMap<>();
        for (Country c: arr){
            map.put(c.getName(),c);
        }
        return map;
    }

    private String[] contriesNames(){
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<this.cts.size();i++){
            list.add(cts.get(i).getName());
        }
        String[] arr = new String[list.size()];
        arr = list.toArray(arr);
        return arr;
    }

    private void initArray(){
        try{
            JSONObject json = new JSONObject(this.loadJSON());
            JSONArray paises = json.getJSONArray("paises");
            for (int i=0; i<paises.length();i++){
                JSONObject jsonObject = paises.getJSONObject(i);
                String capital = jsonObject.getString("capital");
                String name = jsonObject.getString("nombre_pais");
                String int_name = jsonObject.getString("nombre_pais_int");
                String code = jsonObject.getString("sigla");
                Country c = new Country(capital,name,int_name,code);
                this.cts.add(c);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return;
        }

    }

    private String loadJSON(){
        String json = null;
        try{
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}

