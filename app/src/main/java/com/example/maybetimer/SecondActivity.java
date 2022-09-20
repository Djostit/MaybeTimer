package com.example.maybetimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    int seconds = 0;
    boolean isRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle argument = getIntent().getExtras();
        seconds = (int) argument.get("Seconds");

        textView = findViewById(R.id.textView);

        runTimer();
        isRunning = true;
    }
    private void runTimer() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (seconds == 0) {
                    isRunning = false;
                }
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;


                String time = String.format("%02d:%02d:%02d", hours, minutes, sec);
                textView.setText(time);
                if (isRunning && seconds > 0) {
                    seconds--;
                    }
                handler.postDelayed(this, 1000);
            }
        });
    }
}