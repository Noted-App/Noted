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

import java.io.File;


public class newActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treblenew);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        seekbarr();


        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3Selected = false;
        imageButton3.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                Toast.makeText(getApplicationContext(), "in the movement", Toast.LENGTH_SHORT).show();
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    imageButton3Selected = true;
                    // add new ImageButton, save in activeButton
                }//end if

                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    if (imageButton3Selected == true)
                    {
                        imageButton3Selected = false;
                    }//end if
                }//end if
                else if (event.getAction() == MotionEvent.ACTION_MOVE)
                {
                    if (imageButton3Selected == true)
                    {
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, 300);
                        params.setMargins((int)event.getRawX() - 25, (int) event.getRawY() - 50, 0, 0);
                        LinearLayout layout = (LinearLayout) findViewById(R.id.gllayout);
                        layout.removeView(imageButton3);
                        layout.addView(imageButton3, params);
                    }//end if
                }//end else

                return false;
            }//end onTouch function

        });



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











