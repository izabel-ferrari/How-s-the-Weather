
package pcs3614.howstheweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Parcelable{

    private CurrenWeather currenWeather;
    private List<Forecast> forecastList = new ArrayList<Forecast>();

    public Weather(JSONObject jsonObject) {
        try {
            JSONObject jsonObjectCurrenWeather = jsonObject.getJSONArray("curren_weather").optJSONObject(0);
            currenWeather = new CurrenWeather(jsonObjectCurrenWeather);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonArrayForecast = jsonObject.getJSONArray("forecast");
            for (int i = 0; i < jsonArrayForecast.length(); i++) {
                JSONObject jsonObjectForecast = jsonArrayForecast.optJSONObject(i);
                forecastList.add(new Forecast(jsonObjectForecast));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public CurrenWeather getCurrenWeather() {
        return currenWeather;
    }

    public List<Forecast> getForecastList() {
        return forecastList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(currenWeather, i);
        parcel.writeTypedList(forecastList);
    }

    Weather(Parcel in) {
        currenWeather = in.readParcelable(CurrenWeather.class.getClassLoader());
        in.readTypedList(forecastList, Forecast.CREATOR);
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}
