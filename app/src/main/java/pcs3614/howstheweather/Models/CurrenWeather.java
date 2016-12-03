
package pcs3614.howstheweather.Models;

import org.json.JSONObject;


public class CurrenWeather {

    private String humidity;
    private String pressure;
    private String temp;
    private String tempUnit;
    private String weatherCode;
    private String weatherText;
    private Wind wind;

    CurrenWeather(JSONObject jsonObject) {
        humidity = jsonObject.optString("humidity");
        pressure = jsonObject.optString("pressure");
        temp = jsonObject.optString("temp");
        tempUnit = jsonObject.optString("temp_unit");
        weatherCode = jsonObject.optString("weather_code");
        weatherText = jsonObject.optString("weather_text");
        JSONObject jsonObjectWind = jsonObject.optJSONArray("wind").optJSONObject(0);
        wind = new Wind(jsonObjectWind);
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public String getTemp() {
        return temp;
    }

    public String getTempUnit() {
        return tempUnit;
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
