package com.example.student.noted;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.content.pm.ActivityInfo;
import android.graphics.Paint;
import android.os.IBinder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;


public class newActivity extends AppCompatActivity {
    private final int PADDING_OFFSET = 32;
    private static SeekBar seekbar;

    private static TextView textViews;

    private Context mContext;
    private Resources mResources;
    private RelativeLayout mRelativeLayout;
    private Button mButton;
    private ImageView mImageView;

    private ImageButton imageButton3;
    private boolean imageButton3Selected;

    private ImageButton activeButton;
    private int currentDrawableId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treblenew);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        seekbarr();}

    public boolean onTouchEvent(MotionEvent event) {
        // MotionEvent object holds X-Y values
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            String text = "You click at x = " + event.getX() + " and y = " + event.getY();
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();

            RelativeLayout.LayoutParams noteLayout;

//             decision logic to get note type, then set image size/ratio based on that type.
//             So, quarternote is a 3.5:10 aspect ratio. the ImageView needs to have dimensions
//             that honor this ratio. Once those values for x and y are determined, the LayoutParams
//             can be assigned.  Then the offsets can be subtracted in the setX/setY. Maybe create
//             class scoped variables to hold those measurement values.

            int touchX = (int) event.getRawX();
            int touchY = (int) event.getRawY();

            ImageView view = new ImageView(this);
            view.setLayoutParams(new RelativeLayout.LayoutParams(27,75));
            Glide.with(this).load(R.drawable.quarternote).into(view);

            view.setX(touchX - view.getWidth() - PADDING_OFFSET);
            view.setY(touchY - view.getHeight() - PADDING_OFFSET);

            RelativeLayout staffLayout = (RelativeLayout)findViewById(R.id.activity_new);
            staffLayout.addView(view, 0);
        }

        return super.onTouchEvent(event);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton1:
                  currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton2:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton3:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton4:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton5:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton6:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton7:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton8:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton9:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton10:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton11:
                currentDrawableId = R.drawable.quarternote;
                break;
            case R.id.imageButton12:
                currentDrawableId = R.drawable.quarternote;
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }






    public void seekbarr() {


        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setMax(300);
        textViews = (TextView) findViewById(R.id.textViews);
        textViews.setText("BMP : " + seekbar.getProgress());





        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value = progress;
                textViews.setText("BMP : " + progress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Toast.makeText(newActivity.this, "Tempo Change", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViews.setText("BMP : " + progress_value);

            }
        });
    }


}















//    public class MainActivity extends Activity {
//        ImageView drawingImageView;
//
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//            drawingImageView = (ImageView) this.findViewById(R.id.DrawingImageView);
//            Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
//                    .getDefaultDisplay().getWidth(), (int) getWindowManager()
//                    .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
//            Canvas canvas = new Canvas(bitmap);
//            drawingImageView.setImageBitmap(bitmap);
//
//            // Line
//            Paint paint = new Paint();
//            paint.setColor(Color.rgb(255, 153, 51));
//            paint.setStrokeWidth(10);
//            int startx = 50;
//            int starty = 90;
//            int endx = 150;
//            int endy = 360;
//            canvas.drawLine(startx, starty, endx, endy, paint);
//
//        }
//
//
//
//    }
//
//
//}











