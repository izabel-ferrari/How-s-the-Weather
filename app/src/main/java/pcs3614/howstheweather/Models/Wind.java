
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

    Wind() {
        this.dir = "-";
        this.dirDegree = "-";
        this.speed = "-";
        this.windUnit = "-";
    }

    public String getDir() {
        if (dir == null || dir.length() > 4) {
            return "-";
        }
        return dir;
    }

    public String getDirDegree() {
        if (dirDegree == null || dirDegree.length() > 4) {
            return "-";
        }
        return dirDegree;
    }

    public String getSpeed() {
        if (speed == null || speed.length() > 4) {
            return "-";
        }
        return speed;
    }

    public String getWindUnit() {
        if (windUnit == null || windUnit.length() > 4) {
            return "-";
        }
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
