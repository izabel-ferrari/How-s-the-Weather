
package pcs3614.howstheweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Night implements Parcelable {

    private String weatherCode;
    private String weatherText;
    private Wind wind;

    Night(JSONObject jsonObject) {
        weatherCode = jsonObject.optString("weather_code");
        weatherText = jsonObject.optString("weather_text");
        JSONObject jsonObjectWind = jsonObject.optJSONArray("wind").optJSONObject(0);
        wind = new Wind(jsonObjectWind);
    }

    Night() {
        this.weatherCode = "-";
        this.weatherText = "-";
        this.wind = (new Wind());
    }

    public String getWeatherCode() {
        if (weatherCode == null) {
            return "-999";
        }
        return weatherCode;
    }

    public String getWeatherText() {
        if (weatherText == null) {
            return "-";
        }
        return weatherText;
    }

    public Wind getWind() {
        if (wind == null) {
            return (new Wind());
        }
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

    Night(Parcel in) {
        weatherCode = in.readString();
        weatherText = in.readString();
        wind = in.readParcelable(Wind.class.getClassLoader());
    }

    public static final Parcelable.Creator<Night> CREATOR = new Parcelable.Creator<Night>() {
        @Override
        public Night createFromParcel(Parcel in) {
            return new Night(in);
        }

        @Override
        public Night[] newArray(int size) {
            return new Night[size];
        }
    };

}
