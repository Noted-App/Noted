package com.example.student.noted;


import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class newActivity extends AppCompatActivity implements View.OnClickListener{
    private final int PADDING_OFFSET = 32;
    private static SeekBar seekbar;

    private static TextView textViews;

    private int currentDrawableId = 0;
    private int imageWidth;
    private final int imageHeight = 75;
    private final int repeatImageHeight = 150;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Instance state","onSaveInstanceState");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("Instance state","onRestoreInstanceState");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treblenew);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        seekbarr();

        ImageButton note = (ImageButton) findViewById(R.id.quarternote);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.eighthnoterest);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.eighthnotes);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.dottedhalfnote2);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.halfnote);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.sixteenthnotes);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.wholenote);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.quarternoterest);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.halfnoterest);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.wholenoterest);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.creshendo);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.repeatsign);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.eighthnotes);
        note.setOnClickListener(this);
        note = (ImageButton) findViewById(R.id.eighthnotes);
        note.setOnClickListener(this);

    }

    public boolean onTouchEvent(MotionEvent event) {

        // if no drawable selected yet - ignore (or do something else)

        // MotionEvent object holds X-Y values
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            String text = "Image ratio: " + imageWidth + "/" + imageHeight;
//            Toast.makeText(this, text, Toast.LENGTH_LONG).show();

            RelativeLayout.LayoutParams noteLayout;

//             decision logic to get note type, then set image size/ratio based on that type.
//             So, quarternote is a 3.5:10 aspect ratio. the ImageView needs to have dimensions
//             that honor this ratio. Once those values for x and y are determined, the LayoutParams
//             can be assigned.  Then the offsets can be subtracted in the setX/setY. Maybe create
//             class scoped variables to hold those measurement values.

            int touchX = (int) event.getRawX();
            int touchY = (int) event.getRawY();

            ImageView view = new ImageView(this);

            // if image is repeat bar, use different height
            view.setLayoutParams(new RelativeLayout.LayoutParams(imageWidth, imageHeight));

            Glide.with(this).load(currentDrawableId)/*.override(1000, 1000)*/.into(view);

            // todo add more offset to bring note to bottom middle of click (instead of top-left)
            view.setX(touchX - view.getWidth() - PADDING_OFFSET);
            view.setY(touchY - view.getHeight() - PADDING_OFFSET);

            RelativeLayout staffLayout = (RelativeLayout)findViewById(R.id.activity_new);
            staffLayout.addView(view, 0);
        }

        return super.onTouchEvent(event);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quarternote:
                currentDrawableId = R.drawable.quarternote;
                imageWidth = (int)(.358 * imageHeight);
                break;
            case R.id.eighthnoterest:
                currentDrawableId = R.drawable.eighthnoterest;
                imageWidth = (int)(.418 * (imageHeight));
                break;
            case R.id.eighthnotes:
                currentDrawableId = R.drawable.eighthnotes;
                imageWidth = (int)(.989 * imageHeight);
                break;
            case R.id.dottedhalfnote2:
                currentDrawableId = R.drawable.dottedhalfnote2;
                imageWidth = (int)(.458 * imageHeight);
                break;
            case R.id.halfnote:
                currentDrawableId = R.drawable.halfnote;
                imageWidth = (int)(.413 * imageHeight);
                break;
            case R.id.sixteenthnotes:
                currentDrawableId = R.drawable.sixteenthnotes;
                imageWidth = (int)(.529 * (imageHeight * 2));
                break;
            case R.id.wholenote:
                currentDrawableId = R.drawable.wholenote;
                imageWidth = (int)(.673 * imageHeight);
                break;
            case R.id.quarternoterest:
                currentDrawableId = R.drawable.quarternoterest;
                imageWidth = (int)(.349 * imageHeight);
                break;
            case R.id.halfnoterest:
                currentDrawableId = R.drawable.halfnoterest;
                imageWidth = (int)(.330 * imageHeight);
                break;
            case R.id.wholenoterest:
                currentDrawableId = R.drawable.wholenoterest;
                imageWidth = (int)(.434 * imageHeight);
                break;
            case R.id.creshendo:
                currentDrawableId = R.drawable.creshendo;
                imageWidth = (int)(.771 * imageHeight);
                break;
            case R.id.repeatsign:
                currentDrawableId = R.drawable.repeatsign;
                imageWidth = (int)(.654 * repeatImageHeight);
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
    }






    public void seekbarr() {


        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setMax(300);
        textViews = (TextView) findViewById(R.id.textViews);
        textViews.setText("BMP : " + seekbar.getProgress());





        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress_value;
            int stepsize = 10;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value = ((int)Math.round(progress/stepsize)) *stepsize;
                seekBar.setProgress(progress);
                textViews.setText("BMP : " + progress_value);


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











