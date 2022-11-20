package com.example.zhihu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.zhihu.R;

import java.util.ArrayList;
import java.util.List;



public class clickable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_clickable);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Log.d("hihi",id);


        WebView webView = findViewById(R.id.clickable_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://daily.zhihu.com/story/"+id);
        Log.d("hihi","https://daily.zhihu.com/story/"+id);
    }
}