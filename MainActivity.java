package com.example.myhomeapp;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView appList;
    private View homeImage;
    private boolean isMenuVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // start fullscreen on home
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);

        appList = findViewById(R.id.appList);
        homeImage = findViewById(R.id.homeImage);

        loadApps();

        final GestureDetector gestureDetector = new GestureDetector(this,
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                        if (e1 == null || e2 == null) return false;
                        if (e1.getY() - e2.getY() > 120) {
                            showAppMenu();
                        } else if (e2.getY() - e1.getY() > 120) {
                            hideAppMenu();
                        }
                        return true;
                    }
                });

        homeImage.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));
    }

    private void loadApps() {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps = getPackageManager().queryIntentActivities(intent, 0);

        AppAdapter adapter = new AppAdapter(this, apps);
        appList.setLayoutManager(new GridLayoutManager(this, 4)); // 4 apps per row
        appList.setAdapter(adapter);
    }

    private void showAppMenu() {
        if (!isMenuVisible) {
            appList.setVisibility(View.VISIBLE);
            isMenuVisible = true;
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }

    private void hideAppMenu() {
        if (isMenuVisible) {
            appList.setVisibility(View.GONE);
            isMenuVisible = false;
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }
}
