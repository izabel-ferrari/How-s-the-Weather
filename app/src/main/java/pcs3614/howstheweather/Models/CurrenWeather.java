
package pcs3614.howstheweather.Models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import pcs3614.howstheweather.R;
import pcs3614.howstheweather.Utils.Constants;
import pcs3614.howstheweather.Utils.Formatting;

public class CurrenWeather implements Parcelable {

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

    CurrenWeather() {
        this.humidity = "-";
        this.pressure = "-";
        this.temp = "-";
        this.tempUnit = "-";
        this.weatherCode = "-";
        this.weatherText = "-";
        this.wind = new Wind();
    }

    public String getHumidity() {
        if (humidity == null || humidity.length() > 2) {
            return "-";
        }
        return humidity;
    }

    public String getPressure() {
        if (pressure == null || pressure.length() > 4) {
            return "-";
        }
        return pressure;
    }

    public String getTemp() {
        if (temp == null || temp.length() > 2) {
            return "-";
        }
        return temp;
    }

    public String getTempUnit() {
        if (tempUnit == null) {
            return "-";
        }
        return tempUnit;
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

    public String getEstadoHeader() {
        switch (getEstado()) {
            case Constants.ESTADO_INDISPONIVEL:
                return Constants.ESTADO_INDISPONIVEL_HEADER;
            case Constants.ESTADO_IDEAL:
                return Constants.ESTADO_IDEAL_HEADER;
            case Constants.ESTADO_ATENCAO:
                return Constants.ESTADO_ATENCAO_HEADER;
            case Constants.ESTADO_ALERTA:
                return Constants.ESTADO_ALERTA_HEADER;
            case Constants.ESTADO_EMERGENCIA:
                return Constants.ESTADO_EMERGENCIA_HEADER;
        }
        return (Constants.ESTADO_INDISPONIVEL_HEADER);
    }

    public String getEstadoDescrip() {
        return (Formatting.getEstadoDescripFormatted(getEstado(), getTemp(), getHumidity()));
    }

    private int getEstado() {
        String umidadeStr = this.getHumidity();
        String temperaturaStr = this.getTemp();

        int umidade = -1;
        int temperatura = -1;

        if (umidadeStr.contains("-") || temperaturaStr.contains("-")) {
            return (Constants.ESTADO_INDISPONIVEL);
        }

        umidade = Integer.parseInt(umidadeStr);
        temperatura = Integer.parseInt(temperaturaStr);

        if (umidade > 30) {
            if (temperatura >= 22 && temperatura <= 27) {
                return Constants.ESTADO_IDEAL;
            }
            if (temperatura < 22 || (temperatura > 27 && temperatura <= 30)) {
                return Constants.ESTADO_ATENCAO;
            }
            if (temperatura > 30) {
                return Constants.ESTADO_ATENCAO;
            }
        }
        if (umidade > 20 && umidade <= 30) {
            if (temperatura >= 22 && temperatura <= 27) {
                return Constants.ESTADO_ATENCAO;
            }
            if (temperatura < 22 || (temperatura > 27 && temperatura <= 30)) {
                return Constants.ESTADO_ATENCAO;
            }
            if (temperatura > 30) {
                return Constants.ESTADO_ALERTA;
            }

        }
        if (umidade >= 12 && umidade <= 20) {
            if (temperatura >= 22 && temperatura <= 27) {
                return Constants.ESTADO_ALERTA;
            }
            if (temperatura < 22 || (temperatura > 27 && temperatura <= 30)) {
                return Constants.ESTADO_ALERTA;
            }
            if (temperatura > 30) {
                return Constants.ESTADO_EMERGENCIA;
            }

        }
        if (umidade < 12) {
            if (temperatura >= 22 && temperatura <= 27) {
                return Constants.ESTADO_EMERGENCIA;
            }
            if (temperatura < 22 || (temperatura > 27 && temperatura <= 30)) {
                return Constants.ESTADO_EMERGENCIA;
            }
            if (temperatura > 30) {
                return Constants.ESTADO_EMERGENCIA;
            }

        }
        return (Constants.ESTADO_INDISPONIVEL);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(humidity);
        parcel.writeString(pressure);
        parcel.writeString(temp);
        parcel.writeString(tempUnit);
        parcel.writeString(weatherCode);
        parcel.writeString(weatherText);
        parcel.writeParcelable(wind, i);
    }

    CurrenWeather(Parcel in) {
        humidity = in.readString();
        pressure = in.readString();
        temp = in.readString();
        tempUnit = in.readString();
        weatherCode = in.readString();
        weatherText = in.readString();
        wind = in.readParcelable(Wind.class.getClassLoader());
    }

    public static final Creator<CurrenWeather> CREATOR = new Creator<CurrenWeather>() {
        @Override
        public CurrenWeather createFromParcel(Parcel in) {
            return new CurrenWeather(in);
        }

        @Override
        public CurrenWeather[] newArray(int size) {
            return new CurrenWeather[size];
        }
    };
}