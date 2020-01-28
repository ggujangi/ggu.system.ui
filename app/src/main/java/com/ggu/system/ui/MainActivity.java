package com.ggu.system.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_VISIBLE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewChangeColor;

    Button btnDimming, btnHidingStatusBarLow, btnHidingStatusBarHigh, btnHidingNavigation;
    Button btnImmersive, btnImmersiveSticky, btnImmersiveLeanBack;

    View mDecorView;

    int mOption = SYSTEM_UI_FLAG_VISIBLE;
    boolean isFullScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDecorView = getWindow().getDecorView();

        init();

        mDecorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0){
//                    mOption = SYSTEM_UI_FLAG_VISIBLE;
                    Log.d("SystemUiTest", "Not FullScreen");
                }
                else{
                    Log.d("SystemUiTest", "FullScreen");
                }
            }
        });

        textViewChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Color Picker Dialog
            }
        });

        btnDimming.setOnClickListener(this);
        btnHidingStatusBarLow.setOnClickListener(this);
        btnHidingStatusBarHigh.setOnClickListener(this);
        btnHidingNavigation.setOnClickListener(this);
        btnImmersive.setOnClickListener(this);
        btnImmersiveLeanBack.setOnClickListener(this);
        btnImmersiveSticky.setOnClickListener(this);
    }

    private void init(){
        textViewChangeColor = findViewById(R.id.textView_change_color);

        btnDimming = findViewById(R.id.btn_dimming);
        btnHidingStatusBarLow = findViewById(R.id.btn_hiding_status_low);
        btnHidingStatusBarHigh = findViewById(R.id.btn_hiding_status_high);
        btnHidingNavigation = findViewById(R.id.btn_hiding_navigation);
        btnImmersive = findViewById(R.id.btn_immersive);
        btnImmersiveLeanBack = findViewById(R.id.btn_immersive_lean_back);
        btnImmersiveSticky = findViewById(R.id.btn_immersive_sticky);
    }

    @Override
    public void onClick(View v) {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mDecorView.setSystemUiVisibility(SYSTEM_UI_FLAG_VISIBLE);

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
                }
                else{
                    mOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
                }
                mDecorView.setSystemUiVisibility(mOption);
                break;

            case R.id.btn_hiding_status_low:
                if(isFullScreen) {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    isFullScreen = false;
                }
                else{
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    isFullScreen = true;
                }
                break;

            case R.id.btn_hiding_navigation:
                // (Both)
                // mOption = SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
                mOption = SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                mDecorView.setSystemUiVisibility(mOption);
                break;

            case R.id.btn_immersive_lean_back:
                mOption = View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                mDecorView.setSystemUiVisibility(mOption);
                break;

            case R.id.btn_immersive:
                mOption = View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                mDecorView.setSystemUiVisibility(mOption);
                break;

            case R.id.btn_immersive_sticky:
                mOption = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                mDecorView.setSystemUiVisibility(mOption);
                break;
        }
    }
}
