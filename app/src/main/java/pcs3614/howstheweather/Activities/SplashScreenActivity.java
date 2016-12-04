package pcs3614.howstheweather.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import pcs3614.howstheweather.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = "SplashScreenActivity";
    Activity activity = this;
    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        mContentView = findViewById(R.id.text_fullscreen_content);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(activity, MainActivity.class));
                activity.finish();
            }
        }, 3000);
    }
}
