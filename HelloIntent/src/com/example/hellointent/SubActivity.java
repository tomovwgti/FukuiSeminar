package com.example.hellointent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        
        // Intentを取得する
        Intent intent = getIntent();
        // Intentから文字列を取得する
        String text = intent.getStringExtra("EDIT_TEXT");
        // TextViewに取得した文字列をセットする
        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(text);
    }
}
