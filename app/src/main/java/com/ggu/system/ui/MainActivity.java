package com.ggu.system.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout containerLayout;

    Button btnDimming, btnHidingStatusBarLow, btnHidingStatusBarHigh, btnHidingNavigation;
    Button btnImmersive, btnImmersiveSticky, btnImmersiveLeanBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        containerLayout = findViewById(R.id.ll_container);

        btnDimming = findViewById(R.id.btn_dimming);
        btnHidingStatusBarLow = findViewById(R.id.btn_hiding_status_low);
        btnHidingStatusBarHigh = findViewById(R.id.btn_hiding_status_high);
        btnHidingNavigation = findViewById(R.id.btn_hiding_navigation);
        btnImmersive = findViewById(R.id.btn_immersive);
        btnImmersiveLeanBack = findViewById(R.id.btn_immersive_lean_back);
        btnImmersiveSticky = findViewById(R.id.btn_immersive_sticky);

        btnDimming.setOnClickListener(this);
        btnHidingStatusBarLow.setOnClickListener(this);
        btnHidingStatusBarHigh.setOnClickListener(this);
        btnHidingNavigation.setOnClickListener(this);
        btnImmersive.setOnClickListener(this);
        btnImmersiveLeanBack.setOnClickListener(this);
        btnImmersiveSticky.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dimming:
                break;
            case R.id.btn_hiding_status_high:
                break;
            case R.id.btn_hiding_status_low:
                break;
            case R.id.btn_hiding_navigation:
                break;
            case R.id.btn_immersive_lean_back:
                break;
            case R.id.btn_immersive:
                break;
            case R.id.btn_immersive_sticky:
                break;
        }
    }
}
