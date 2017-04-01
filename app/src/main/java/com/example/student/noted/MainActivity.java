package com.example.student.noted;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void sendHelp(View view)
    {
        Intent intent = new Intent(MainActivity.this, helpActivity.class);
        startActivity(intent);

    }


    public void sendSaved(View view)
    {
        Intent intent = new Intent(MainActivity.this, savedActivity.class);
        startActivity(intent);

    }

    public void sendNew(View view)
    {
        Intent intent = new Intent(MainActivity.this, newActivity.class);
        startActivity(intent);

    }






}

