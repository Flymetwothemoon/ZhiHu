package com.example.zhihu.Activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.example.zhihu.R;
import com.example.zhihu.addFragment;
import com.example.zhihu.guanzhuFragment;
import com.example.zhihu.huiyuan.huiyuanFragment;
import com.example.zhihu.shouye.shouyeFragment;
import com.example.zhihu.wodeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import Adapter.quanzhan_Recycler.news;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView navigationView;
    public List<news> mList1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //透明状态栏
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_bottom);
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setSelectedItemId(R.id.bottom_shouye);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()){
            case R.id.bottom_shouye:
                fragmentTransaction.replace(R.id.nav_host_fragment, new shouyeFragment()).commit();
                return true;
            case R.id.bottom_add:
                fragmentTransaction.replace(R.id.nav_host_fragment,new addFragment()).commit();
                return true;
            case R.id.bottom_guanzhu:
                fragmentTransaction.replace(R.id.nav_host_fragment,new guanzhuFragment()).commit();
                return true;
            case R.id.bottom_wode:
                fragmentTransaction.replace(R.id.nav_host_fragment,new wodeFragment()).commit();
                return true;
            case R.id.botton_huiyuan:
                fragmentTransaction.replace(R.id.nav_host_fragment,new huiyuanFragment()).commit();
        }
        return true;

    }
}





