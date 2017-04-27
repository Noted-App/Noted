package com.example.student.noted;


import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class newActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treblenew);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    }
    public class mnew_activity extends AppCompatActivity
    {
        //variable for counting two successive up-down events
        int clickCount = 0;
        //variable for storing the time of first click
        long startTime;
        //variable for calculating the total time
        long duration;
        //constant for defining the time duration between the click that can be considered as double-tap
        static final int MAX_DURATION = 500;
    }

}
