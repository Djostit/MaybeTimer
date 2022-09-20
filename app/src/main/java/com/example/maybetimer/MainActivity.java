package com.example.maybetimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    private int seconds;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        runTimer();
    }
    public void TurnTimer(View view) {
        isRunning = true;
    }
    private void GoAnther(int seconds){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Seconds", seconds);
        startActivity(intent);
    }
    private void runTimer() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (seconds == 10) {
                    isRunning = false;
                    GoAnther(seconds);
                    return;
                }
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format("%02d:%02d:%02d", hours, minutes, sec);
                textView.setText(time);
                if (isRunning) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}