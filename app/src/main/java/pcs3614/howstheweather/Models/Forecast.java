
package pcs3614.howstheweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Forecast implements Parcelable{

    private String date;
    private Day day;
    private String dayMaxTemp;
    private Night night;
    private String nightMinTemp;
    private String tempUnit;

    Forecast(JSONObject jsonObject) {
        date = jsonObject.optString("date");
        JSONObject jsonObjectDay = jsonObject.optJSONArray("day").optJSONObject(0);
        day = new Day(jsonObjectDay);
        dayMaxTemp = jsonObject.optString("day_max_temp");
        JSONObject jsonObjectNight = jsonObject.optJSONArray("night").optJSONObject(0);
        night = new Night(jsonObjectNight);
        nightMinTemp = jsonObject.optString("night_min_temp");
        tempUnit = jsonObject.optString("temp_unit");
    }

    public String getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }

    public String getDayMaxTemp() {
        return dayMaxTemp;
    }

    public Night getNight() {
        return night;
    }

    public String getNightMinTemp() {
        return nightMinTemp;
    }

    public String getTempUnit() {
        return tempUnit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
        parcel.writeParcelable(day, i);
        parcel.writeString(dayMaxTemp);
        parcel.writeParcelable(night, i);
        parcel.writeString(nightMinTemp);
        parcel.writeString(tempUnit);
    }

    Forecast(Parcel in) {
        date = in.readString();
        day = in.readParcelable(Day.class.getClassLoader());
        dayMaxTemp = in.readString();
        night = in.readParcelable(Night.class.getClassLoader());
        nightMinTemp = in.readString();
        tempUnit = in.readString();
    }

    public static final Parcelable.Creator<Forecast> CREATOR = new Parcelable.Creator<Forecast>() {
        @Override
        public Forecast createFromParcel(Parcel in) {
            return new Forecast(in);
        }

        @Override
        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };
}
