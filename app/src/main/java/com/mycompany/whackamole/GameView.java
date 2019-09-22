    package com.mycompany.whackamole;

    import android.content.Context;
    import android.graphics.Bitmap;
    import android.graphics.BitmapFactory;
    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.view.MotionEvent;
    import android.view.SurfaceHolder;
    import android.view.SurfaceView;
    import java.util.Random;
    import android.os.Vibrator;

    public class GameView extends SurfaceView implements Runnable {

    private SurfaceHolder holder;
    private Vibrator v ;
    public static int score = 0;
    int width , height ;
    Paint paint = new Paint();
    int sleepTime = 500 ;
    int touchX , touchY ;
        Canvas can ;
    boolean moleUp1 , moleUp0 , moleUp2 , moleUp3 ;
    Context context;
        private int mole1left = width / 8 - 10 , mole2left = width - 150 - 8 , mole3left = width / 8 - 50 + 20 + 20 , mole4left = width - 150 - 8 ;
        private int mole1top = height / 8 - 20 , mole2top = height / 8 - 20 + 20 - 20 , mole3top = height / 8 + 200 - 20 + 20 - 20 , mole4top = height / 8 + 200 - 20 + 20 - 20 ;
        Random holes2Random = new Random();
        int holes2;
        Thread t = null ;
    private static int minSleepTime = 100 ;
    volatile boolean isitOK = false ;
    private Bitmap moleImage ;

    private void changeMoleExcept1(Canvas canvas) {
        holes2 = holes2Random.nextInt(3);
        switch (holes2) {
            case 0:
                canvas.drawBitmap(moleImage, width - 150, height / 8 - 30, paint);
                moleUp0 = false ;
                moleUp1 = true ;
                moleUp2 = false ;
                moleUp3 = false ;
                break;
            case 1:
                canvas.drawBitmap(moleImage, width / 8 - 20 , height / 8 + 160 , paint);
                moleUp0 = false ;
                moleUp1 = false ;
                moleUp2 = true ;
                moleUp3 = false ;
                break;
            case 2:
                canvas.drawBitmap(moleImage, width - 150 , height / 8 + 160 , paint);
                moleUp0 = false ;
                moleUp1 = false ;
                moleUp2 = false ;
                moleUp3 = true ;
                break;

        }
    }

        private void changeMoleExcept2(Canvas canvas) {
            holes2 = holes2Random.nextInt(3);
            switch (holes2) {
                case 0:
                    canvas.drawBitmap(moleImage , width / 8 - 20 , height / 8 - 30 , paint);
                    moleUp0 = true ;
                    moleUp1 = false ;
                    moleUp2 = false ;
                    moleUp3 = false ;
                    break;
                case 1:
                    canvas.drawBitmap(moleImage, width / 8 - 20 , height / 8 + 160 , paint);
                    moleUp0 = false ;
                    moleUp1 = false ;
                    moleUp2 = true ;
                    moleUp3 = false ;
                    break;
                case 2:
                    canvas.drawBitmap(moleImage, width - 150 , height / 8 + 160 , paint);
                    moleUp0 = false ;
                    moleUp1 = false ;
                    moleUp2 = false ;
                    moleUp3 = true ;
                    break;

            }
        }

        private void changeMoleExcept3(Canvas canvas) {
            holes2 = holes2Random.nextInt(3);
            switch (holes2) {
                case 0:
                    canvas.drawBitmap(moleImage , width / 8 - 20 , height / 8 - 30 , paint);
                    moleUp0 = true ;
                    moleUp1 = false ;
                    moleUp2 = false ;
                    moleUp3 = false ;
                    break;
                case 1:
                    canvas.drawBitmap(moleImage, width - 150, height / 8 - 30, paint);
                    moleUp0 = false ;
                    moleUp1 = true ;
                    moleUp2 = false ;
                    moleUp3 = false ;
                    break;
                case 2:
                    canvas.drawBitmap(moleImage, width - 150 , height / 8 + 160 , paint);
                    moleUp0 = false ;
                    moleUp1 = false ;
                    moleUp2 = false ;
                    moleUp3 = true ;
                    break;

            }
        }

        private void changeMoleExcept4(Canvas canvas) {
            holes2 = holes2Random.nextInt(3);
            switch (holes2) {
                case 0:
                    canvas.drawBitmap(moleImage , width / 8 - 20 , height / 8 - 30 , paint);
                    moleUp0 = true ;
                    moleUp1 = false ;
                    moleUp2 = false ;
                    moleUp3 = false ;
                    break;
                case 1:
                    canvas.drawBitmap(moleImage, width - 150, height / 8 - 30, paint);
                    moleUp0 = false ;
                    moleUp1 = true ;
                    moleUp2 = false ;
                    moleUp3 = false ;
                    break;
                case 2:
                    canvas.drawBitmap(moleImage, width / 8 - 20 , height / 8 + 160 , paint);
                    moleUp0 = false ;
                    moleUp1 = false ;
                    moleUp2 = true ;
                    moleUp3 = false ;
                    break;
            }
        }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN) {


            touchX =(int) event.getX();
            touchY = (int) event.getY();

            if (touchX > width / 8 - 30 && touchX < width / 8 + 110 && touchY > height / 8 + 20 && touchY < height/8 + 140 && moleUp0) {
                if(sleepTime != 0){
                    if(minSleepTime < sleepTime)sleepTime -= 5 ; }
                if(v.hasVibrator()) v.vibrate(100);
                score++;
                changeMoleExcept1(can);
            }
            else if (touchX > width - 180 && touchX < width - 40 && touchY > height / 8 + 20 && touchY < height/8 + 140 && moleUp1) {
                if(sleepTime != 0){
                    if(minSleepTime < sleepTime)sleepTime -= 5 ; }
                if(v.hasVibrator()) v.vibrate(100);
                score++;
                changeMoleExcept2(can);
            }
            else if (touchX > width / 8 - 30 && touchX < width / 8 + 110 && touchY > height / 8 + 220 && touchY < height/8 + 340 && moleUp2) {
                if(sleepTime != 0){
                    if(minSleepTime < sleepTime)sleepTime -= 5 ;}
                if(v.hasVibrator()) v.vibrate(100);
                score++;
                changeMoleExcept3(can);
            }
            else if (touchX > width - 180 && touchX < width - 40 && touchY > height / 8 + 220 && touchY < height/8 + 340 && moleUp3) {
                if(sleepTime != 0){
                    if(minSleepTime < sleepTime)sleepTime -= 5 ;}
                if(v.hasVibrator()) v.vibrate(100);
                score++;
                changeMoleExcept4(can);
            }
            return true;
        }
        return false ;
    }

    public GameView(Context context){
        super(context);
        this.context = context;
        holder = getHolder();
        width = context.getResources().getDisplayMetrics().widthPixels;
        height = context.getResources().getDisplayMetrics().heightPixels;
        v = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);

        moleImage = BitmapFactory.decodeResource(getResources() , R.drawable.mole);

    }

    public void updateScoreAndDifficulty(Canvas canvas) {
        String sc = "Score : " + getScore() + " " ;
        paint.setColor(Color.BLACK);
        canvas.drawText(sc , 0 , sc.length() , paint  );
    }

    public static void setScore(int bScore) {
        score = bScore ;
    }

    public int getScore() {
        return score ;
    }

    @Override
    public void run(){

        while (isitOK) {
            // perform canvas drawing
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!holder.getSurface().isValid()) {
                continue;
            }
            // sprite = new Sprite(OurView.this,blob);
            Canvas c = holder.lockCanvas();
            c.drawARGB(255, 100, 100, 10);
            draw(c);
            updateScoreAndDifficulty(c);

            holder.unlockCanvasAndPost(c);
            can = c ;
        }
    }

        public static void setMinSleepTime(int minsSleepTime) {
            minSleepTime = minsSleepTime ;
        }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawColor(Color.GREEN);


        paint.setColor(Color.rgb(0, 0, 0));
        canvas.drawRect(width / 8 - 50, height / 8, width / 8 + 130, height / 8 + 160, paint);
        canvas.drawRect(width - 150 - 50, height / 8 , width - 30 + 60 - 50, height / 8 + 100 + 60, paint);
        canvas.drawRect(width / 8 - 50, height / 8 + 200, width / 8 + 70 + 60, height / 8 + 100 + 200 + 60, paint);
        canvas.drawRect(width - 150 - 50, height / 8 + 200, width - 30 + 60 - 50, height / 8 + 100 + 200 + 60, paint);

        startMole(canvas);
    }

    private void startMole(Canvas canvas) {
        Random number = new Random();
        int holes;
        updateScoreAndDifficulty(canvas);
        paint.setColor(Color.argb(255, 255, 255, 255));

            holes = number.nextInt(4);

            switch (holes) {
                case 0:
                    canvas.drawBitmap(moleImage , width / 8 - 20 , height / 8 - 30 , paint);
                    moleUp0 = true ;
                    moleUp1 = false ;
                    moleUp2 = false ;
                    moleUp3 = false ;
                    break;
                case 1:
                    canvas.drawBitmap(moleImage, width - 150, height / 8 - 30, paint);
                    moleUp0 = false ;
                    moleUp1 = true ;
                    moleUp2 = false ;
                    moleUp3 = false ;
                    break;
                case 2:
                    canvas.drawBitmap(moleImage, width / 8 - 20 , height / 8 + 160 , paint);
                    moleUp0 = false ;
                    moleUp1 = false ;
                    moleUp2 = true ;
                    moleUp3 = false ;
                    break;
                case 3:
                    canvas.drawBitmap(moleImage, width - 150 , height / 8 + 160 , paint);
                    moleUp0 = false ;
                    moleUp1 = false ;
                    moleUp2 = false ;
                    moleUp3 = true ;
                    break;
            }
        }

    public void pause() {
        isitOK = false;
        while (true) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }// end while
    }

    public void resume() {
        isitOK = true ;
        t = new Thread(this);
        t.start();
    }


}

