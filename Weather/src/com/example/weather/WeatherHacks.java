/**
 * 
 */

package com.example.weather;

import java.io.ByteArrayOutputStream;

import net.arnx.jsonic.JSON;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * バックグラウンドでネットワークにアクセスする
 */
public class WeatherHacks extends AsyncTask<Void, Integer, Integer> {
    private static final String TAG = WeatherHacks.class.getSimpleName();
    private static final String URL = "http://weather.livedoor.com/forecast/webservice/json/v1?city=180010";

    MainActivity mContext;
    ProgressDialog mProgress;
    DefaultHttpClient mGetClient;
    WeatherJson mWeatherJson;

    public interface FinsihListener {
        void onFinishListener(WeatherJson weatherJson);
    }

    public WeatherHacks(MainActivity context) {
        mContext = context;
    }

    /**
     * 実行前に呼ばれる
     */
    @Override
    protected void onPreExecute() {
        mProgress = new ProgressDialog(mContext);
        mProgress.setTitle("取得中");
        mProgress.show();
    }

    /**
     * バックグラウンド処理
     */
    @Override
    protected Integer doInBackground(Void... arg0) {
        mGetClient = new DefaultHttpClient();
        HttpGet request = new HttpGet(URL);
        HttpResponse httpResponse = null;
        try {
            httpResponse = mGetClient.execute(request);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            httpResponse.getEntity().writeTo(outputStream);
            String data = outputStream.toString(); // JSONデータ
            // JSONICを使ってクラスオブジェクトに入れる
            mWeatherJson = JSON.decode(data, WeatherJson.class);
        } catch (Exception e) {
            Log.e(TAG, "Error Execute");
        }
        return Integer.valueOf(httpResponse.getStatusLine().getStatusCode());
    }

    /**
     * バックグラウンド処理が終ったら呼び出される
     */
    @Override
    protected void onPostExecute(Integer result) {
        mProgress.dismiss();
        if (result != HttpStatus.SC_OK) {
            Toast.makeText(mContext, "取得に失敗しました", Toast.LENGTH_SHORT).show();
            return;
        }
        // リスナーの呼び出し
        mContext.onFinishListener(mWeatherJson);
    }
}
