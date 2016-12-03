
package pcs3614.howstheweather.Models;

import org.json.JSONObject;

public class Night {

    private String weatherCode;
    private String weatherText;
    private Wind wind;

    Night(JSONObject jsonObject) {
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
}
