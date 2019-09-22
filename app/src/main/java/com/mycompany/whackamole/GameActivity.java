package com.mycompany.whackamole;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intent ;
    
    private int time = 0;

    int width , height ;

    public GameView gameView;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(getApplicationContext()) ;

        width = this.getResources().getDisplayMetrics().widthPixels ;
        height = this.getResources().getDisplayMetrics().heightPixels ;

        setContentView(gameView);

        intent = getIntent();
        time = SettingsActivity.getTime();
    }

    @Override
    protected void onPause(){
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();

        new CountDownTimer(time * 1000 , 1000) {
            @Override
        public void onFinish() {
            finish();
            }

            @Override
        public void onTick(long millisUntilFinished) {

            }
        }.start();
        System.out.println("started");
    }

    public void finish() {
        Intent beepIntent = new Intent(this , Pop.class);
        startActivity(beepIntent);

    }

}

