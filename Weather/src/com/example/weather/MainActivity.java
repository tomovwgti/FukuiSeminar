
package com.example.weather;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.weather.WeatherHacks.FinsihListener;

public class MainActivity extends Activity implements FinsihListener {

    WeatherHacks mWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeather = new WeatherHacks(this);

        Button btn = (Button) findViewById(R.id.weather);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWeather.execute();
            }
        });
    }

    /**
     * 取得した後にリスナーとして呼ばれる
     */
    @Override
    public void onFinishListener(WeatherJson weatherJson) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(weatherJson.getTitle());
        dialog.setMessage(weatherJson.getDescription().getText());
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }
}
