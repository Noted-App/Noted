package com.example.student.noted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.view.View;


public class trebleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }
    public void sendNew(View view)
    {
        Intent intent = new Intent(trebleActivity.this, newActivity.class);
        startActivity(intent);

    }
    public void sendBassNew(View view)
    {
        Intent intent = new Intent(trebleActivity.this, bassnewActivity.class);
        startActivity(intent);

    }

    public void sendGrandNew(View view)
    {
        Intent intent = new Intent(trebleActivity.this, grandnewActivity.class);
        startActivity(intent);

    }


}