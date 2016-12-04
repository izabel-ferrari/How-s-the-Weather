
package pcs3614.howstheweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Wind implements Parcelable {

    private String dir;
    private String dirDegree;
    private String speed;
    private String windUnit;

    Wind(JSONObject jsonObject) {
        dir = jsonObject.optString("dir");
        dirDegree = jsonObject.optString("dir_degree");
        speed = jsonObject.optString("speed");
        windUnit = jsonObject.optString("wind_unit");
    }

    public String getDir() {
        return dir;
    }

    public String getDirDegree() {
        return dirDegree;
    }

    public String getSpeed() {
        return speed;
    }

    public String getWindUnit() {
        return windUnit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dir);
        parcel.writeString(dirDegree);
        parcel.writeString(speed);
        parcel.writeString(windUnit);
    }

    Wind(Parcel in) {
        dir = in.readString();
        dirDegree = in.readString();
        speed = in.readString();
        windUnit = in.readString();
    }

    public static final Creator<Wind> CREATOR = new Creator<Wind>() {
        @Override
        public Wind createFromParcel(Parcel in) {
            return new Wind(in);
        }

        @Override
        public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };
}
