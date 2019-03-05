package com.example.asmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long startTime=System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long ditanTime=System.currentTimeMillis()-startTime;
        Log.d("className","timt:"+ditanTime);
    }

}
