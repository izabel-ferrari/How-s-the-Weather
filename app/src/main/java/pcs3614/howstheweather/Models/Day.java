
package pcs3614.howstheweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Day implements Parcelable {

    private String weatherCode;
    private String weatherText;
    private Wind wind;

    Day(JSONObject jsonObject) {
        weatherCode = jsonObject.optString("weather_code");
        weatherText = jsonObject.optString("weather_text");
        JSONObject jsonObjectWind = jsonObject.optJSONArray("wind").optJSONObject(0);
        wind = new Wind(jsonObjectWind);
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public Wind getWind() {
        return wind;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(weatherCode);
        parcel.writeString(weatherText);
        parcel.writeParcelable(wind, i);
    }

    Day(Parcel in) {
        weatherCode = in.readString();
        weatherText = in.readString();
        wind = in.readParcelable(Wind.class.getClassLoader());
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };
}
