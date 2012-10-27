package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("CYCLE", "onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CYCLE", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CYCLE", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CYCLE", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CYCLE", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CYCLE", "onDestroy");
    }
}