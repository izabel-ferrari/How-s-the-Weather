
package pcs3614.howstheweather.Models;

import org.json.JSONObject;

public class Wind {

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
}
