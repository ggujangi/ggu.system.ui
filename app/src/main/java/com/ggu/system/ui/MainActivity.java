package com.ggu.system.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.view.View.SYSTEM_UI_FLAG_VISIBLE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout containerLayout;

    Button btnDimming, btnHidingStatusBarLow, btnHidingStatusBarHigh, btnHidingNavigation;
    Button btnImmersive, btnImmersiveSticky, btnImmersiveLeanBack;

    View mDecorView;

    int mOption = SYSTEM_UI_FLAG_VISIBLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDecorView = getWindow().getDecorView();

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

        mDecorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0){
                    Toast.makeText(MainActivity.this, "Not FullScreen", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "FullScreen", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
