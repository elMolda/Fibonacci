package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class ShowWebPageActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_web_page);

        webView = (WebView)findViewById(R.id.webVw);
        String link = getIntent().getStringExtra("link");
        webView.loadUrl(link);
    }
}