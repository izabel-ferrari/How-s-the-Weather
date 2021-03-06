package pcs3614.howstheweather.WebServices;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pcs3614.howstheweather.Models.Weather;
import pcs3614.howstheweather.Utils.Constants;

public class WebServiceRequest {

    private Context context;
    private static final String TAG = "WebServiceRequest";

    public void getForecast(final Context ct, final String cidade) {
        this.context = ct;
        new AsyncTask<String, Void, String>() {
            @Override
            protected void onPreExecute() {
                // Log.d(TAG, "onPreExecute: ");
            }

            @Override
            protected String doInBackground(String... params) {
                String url = Constants.URL.concat((Constants.CIDADES.get(cidade)));
                return requestContent(url);
            }

            @Override
            protected void onPostExecute(String response) {
                Weather weather = null;
                if (response != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONObject jsonWeather = jsonObject.optJSONObject("weather");
                        weather = new Weather(jsonWeather);
                        // Log.d(TAG, "onPostExecute: " + weather.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(Constants.BROADCAST_WEATHER);
                intent.putExtra("weather", weather);
                context.sendBroadcast(intent);
            }

        }.execute();
    }

    private String requestContent(String url) {
        // Log.d(TAG, "requestContent: " + url);
        HttpClient httpClient = new DefaultHttpClient();
        String result = null;
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = null;
        InputStream inputStream = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();

            if (httpEntity != null) {
                inputStream = httpEntity.getContent();
                result = convertStreamToString(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }
        return result;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
