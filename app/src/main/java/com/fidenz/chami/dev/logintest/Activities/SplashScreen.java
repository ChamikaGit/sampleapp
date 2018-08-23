package com.fidenz.chami.dev.logintest.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fidenz.chami.dev.logintest.R;

public class SplashScreen extends AppCompatActivity {
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
        startTimer();
    }

    private void startTimer() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                textViewMessage.setText("Wait for two more seconds...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                showMainActivity();
            }
        });
        thread.start();
    }

    private void showMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}