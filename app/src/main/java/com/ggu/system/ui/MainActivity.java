package com.ggu.system.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
                    mOption = SYSTEM_UI_FLAG_VISIBLE;
//                    Toast.makeText(MainActivity.this, "Not FullScreen", Toast.LENGTH_SHORT).show();
                    Log.d("SystemUiTest", "Not FullScreen");
                }
                else{
//                    Toast.makeText(MainActivity.this, "FullScreen", Toast.LENGTH_SHORT).show();
                    Log.d("SystemUiTest", "FullScreen");
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dimming:
                if(mOption == View.SYSTEM_UI_FLAG_LOW_PROFILE){
                    mOption = SYSTEM_UI_FLAG_VISIBLE;
                    Toast.makeText(MainActivity.this, "다시 보입니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    mOption = View.SYSTEM_UI_FLAG_LOW_PROFILE;
                    Toast.makeText(MainActivity.this, "흐려집니다.", Toast.LENGTH_SHORT).show();
                }
                mDecorView.setSystemUiVisibility(mOption);
                break;
            case R.id.btn_hiding_status_high:
                if(mOption == (View.SYSTEM_UI_FLAG_FULLSCREEN)){
                    mOption = SYSTEM_UI_FLAG_VISIBLE;
                    Toast.makeText(MainActivity.this, "Full Screen X.", Toast.LENGTH_SHORT).show();
                }
                else{
                    mOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
                    Toast.makeText(MainActivity.this, "Full Screen O.", Toast.LENGTH_SHORT).show();
                }
                mDecorView.setSystemUiVisibility(mOption);
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
