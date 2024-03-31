package com.example.dinelink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dinelink.login.LoginRolePage;

public class SplashScreen extends AppCompatActivity {

    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        vv = findViewById(R.id.SplashScreenVideo);
        String videoPath = "android.resource://" +getPackageName() + "/" + R.raw.dinelink;
        vv.setVideoPath(videoPath);
        vv.start();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run () {
                    startActivity(new Intent(SplashScreen.this, LoginRolePage.class));
                    finish();
                }
            }, 3000);

    }
}