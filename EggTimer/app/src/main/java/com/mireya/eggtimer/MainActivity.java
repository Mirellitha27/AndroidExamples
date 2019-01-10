package com.mireya.eggtimer;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private Button btnGo;
   private TextView timerTextView;
   private SeekBar timerSeeBar;
   private Boolean counterIsActive = false;
   private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerSeeBar = findViewById(R.id.TimerSeekBar);
        timerTextView = findViewById(R.id.txtCountDown);

        timerSeeBar.setMax(600);
        timerSeeBar.setProgress(30);

        timerSeeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (counterIsActive) {
                    resetTimer();
                } else {
                    counterIsActive = true;
                    timerSeeBar.setEnabled(false);
                    btnGo.setText("Stop");

                    countDownTimer = new CountDownTimer(timerSeeBar.getProgress() * 1000 + 100, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            updateTimer((int) millisUntilFinished / 1000);
                        }

                        @Override
                        public void onFinish() {
                            Log.i("Finish", "Timer all done");
                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.op_caracol);
                            mediaPlayer.start();
                            resetTimer();
                        }
                    }.start();
                }
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void updateTimer(int secondLeft){
        int minutes = secondLeft / 60;
        int seconds = secondLeft - (minutes*60);

        String secondString = Integer.toString(seconds);
        if (seconds <= 9){
            secondString = "0" + secondString;
        }
        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }
    @SuppressLint("SetTextI18n")
    public void resetTimer(){
        timerTextView.setText("0:30");
        timerSeeBar.setProgress(30);
        timerSeeBar.setEnabled(true);
        countDownTimer.cancel();
        btnGo.setText("Go!");
        counterIsActive = false;
    }
}
