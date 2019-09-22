package com.mycompany.whackamole;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    Intent intent;
    Intent gameStart;
    TextView timeText;
    public static int time = 60;
    Button medButton , easButton , harButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        intent = getIntent();

        timeText = (TextView) findViewById(R.id.timeText);

        timeText.setText(String.valueOf(time));

        medButton = (Button) findViewById(R.id.medium_button);
        easButton = (Button) findViewById(R.id.easy_button);
        harButton = (Button) findViewById(R.id.hard_button);

        medButton.setBackgroundResource(R.drawable.difficulty_medium_pressed);

        GameView.setMinSleepTime(400);

    }

    public void increaseScore(View view) {

        time += 5 ;
        timeText.setText("" + time);

    }

    public void decreaseScore(View view) {

        time -= 5 ;
        timeText.setText("" + time);

    }

    public void startGame(View view) {
        gameStart = new Intent(this , GameActivity.class);
        startActivity(gameStart);
    }

    public static int getTime() {
        return time ;
    }

    public void easyDiff(View view) {
        GameView.setMinSleepTime(800);
        easButton.setBackgroundResource(R.drawable.difficulty_easy_pressed);
        medButton.setBackgroundResource(R.drawable.difficulty_medium_enabled);
        harButton.setBackgroundResource(R.drawable.difficulty_hard_enabled);

    }

    public void mediumDiff(View view) {
        GameView.setMinSleepTime(550);
        easButton.setBackgroundResource(R.drawable.difficulty_easy_enabled);
        medButton.setBackgroundResource(R.drawable.difficulty_medium_pressed);
        harButton.setBackgroundResource(R.drawable.difficulty_hard_enabled);
    }

    public void hardDiff(View view) {
        GameView.setMinSleepTime(400);
        easButton.setBackgroundResource(R.drawable.difficulty_easy_enabled);
        medButton.setBackgroundResource(R.drawable.difficulty_medium_enabled);
        harButton.setBackgroundResource(R.drawable.difficulty_hard_pressed);
    }

}
