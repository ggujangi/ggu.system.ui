package com.ggu.system.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_VISIBLE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    NestedScrollView scrollView;

    Button btnDimming, btnHidingStatusBarLow, btnHidingStatusBarHigh, btnHidingNavigation;
    Button btnImmersive, btnImmersiveSticky, btnImmersiveLeanBack;

    View mDecorView;

    int mOption = SYSTEM_UI_FLAG_VISIBLE;
    boolean isFullScreen = false;

    GestureDetector gestureDetector = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDecorView = getWindow().getDecorView();

        scrollView = findViewById(R.id.scrollView_main);

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

        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

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

        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {}

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Toast.makeText(MainActivity.this, "onSingleTap", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) { return false; }

            @Override
            public void onLongPress(MotionEvent e) {}

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) { return false; }
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
                break;
        }
    }
}
