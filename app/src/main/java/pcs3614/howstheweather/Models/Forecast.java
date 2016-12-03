
package pcs3614.howstheweather.Models;

import org.json.JSONObject;

public class Forecast {

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
}
