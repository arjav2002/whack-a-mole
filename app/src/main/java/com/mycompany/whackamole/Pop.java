package com.mycompany.whackamole;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.mycompany.whackamole.GameView.*;

public class Pop extends AppCompatActivity{

    int width , height ;
    TextView textView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_activity);

        width = getResources().getDisplayMetrics().widthPixels;
        height = getResources().getDisplayMetrics().heightPixels;
        getWindow().setLayout( (int) (width * 0.9) , (int)(height * 0.5));

        textView = (TextView) findViewById(R.id.dialogue_textView);
        setScoreText();
        intent = getIntent();
    }

    public void goToStart(View view) {
        Intent boo = new Intent(this , StartActivity.class);
        startActivity(boo);
    }

    private void setScoreText() {
        textView.setText(String.valueOf("Time's up! Your score was " + score));
    }

}
