package com.mycompany.whackamole;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class StartActivity extends AppCompatActivity {

    Paint paint ;
    Intent startIntent , settingsIntent;
    Bitmap bitmap ;
    Canvas canvas ;
    int width , height ;
    Button startButton ;
    public static final String EXTRA_STARTED = "com.mycompany.whackamole.EXTRA_STARTED" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        width = getApplicationContext().getResources().getDisplayMetrics().widthPixels ;
        height = getApplicationContext().getResources().getDisplayMetrics().heightPixels ;
        System.out.println("Screen width is " + width);

        setContentView(R.layout.activity_start);

        paint = new Paint() ;
        paint.setColor(Color.rgb(0, 255, 0));

        bitmap = Bitmap.createBitmap(width , height , Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bitmap) ;
        canvas.drawRect(0 , 0 , width , height , paint);

        paint.setColor(Color.rgb(0 , 0 , 0));

        canvas.drawRect(width / 8 - 50, height / 8, width / 8 + 130, height / 8 + 160, paint);
        canvas.drawRect(width - 150 - 50, height / 8 , width - 30 + 60 - 50, height / 8 + 100 + 60, paint);
        canvas.drawRect(width / 8 - 50, height / 8 + 200, width / 8 + 70 + 60, height / 8 + 100 + 200 + 60, paint);
        canvas.drawRect(width - 150 - 50, height / 8 + 200, width - 30 + 60 - 50, height / 8 + 100 + 200 + 60, paint);

        startButton = (Button) findViewById(R.id.StartButton);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.rect);
        layout.setBackgroundDrawable(new BitmapDrawable(bitmap));

        GameView.setScore(0);
    }

    public void startGame(View view) {

            startIntent = new Intent(this , GameActivity.class);
            startActivity(startIntent);

    }

    public void settings(View view) {

        settingsIntent = new Intent(this , SettingsActivity.class);
        startActivity(settingsIntent);

    }
}
