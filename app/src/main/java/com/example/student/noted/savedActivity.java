package com.example.student.noted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class savedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
    }
    public void sendNew(View view)
    {
        Intent intent = new Intent(savedActivity.this, newActivity.class);
        startActivity(intent);

    }
}
