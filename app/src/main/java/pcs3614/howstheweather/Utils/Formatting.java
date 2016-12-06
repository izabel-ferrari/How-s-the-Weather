package pcs3614.howstheweather.Utils;


import java.text.SimpleDateFormat;
import java.util.Date;

import pcs3614.howstheweather.R;

public class Formatting {

    public static String getCurrentDate() {
        String currentMonth = new SimpleDateFormat("MM").format(new Date());
        String currentDay = new SimpleDateFormat("dd").format(new Date());
        currentMonth = Constants.MESES.get(currentMonth);
        return currentDay + " de " + currentMonth;
    }

    public static String getDate(String date) {
        String[] dateSplit = date.split("-");
        String month = dateSplit[1];
        String day = dateSplit[2];
        month = Constants.MESES.get(month);
        return day + " de " + month;
    }

    public static String getTemperature(String temperature) {
        return temperature + " ºC";
    }

    public static String getDescription(String description) {
        return Constants.DESCRICAO.get(description);
    }

    public static String getHumidity(String humidity) {
        return "Umidade: " + humidity + " %";
    }

    public static String getPressure(String pressure) {
        return "Pressão: " + pressure + " hPa";
    }

    public static String getWind(String wind) {
        return "Vento: " + wind + " km/h";
    }


    public static int getDayIcon(String weather) {
        int weatherCode = Integer.parseInt(weather);
        switch (weatherCode) {
            case 0:
                return (R.drawable.sunny);
            case 1:
                return (R.drawable.partlycloudyday);
            case 2:
                return (R.drawable.cloudy);
            case 3:
                return (R.drawable.overcast);
            case 10:
                return (R.drawable.mist);
            case 21:
                return (R.drawable.occlightrain);
            case 22:
                return (R.drawable.isosleetswrsday);
            case 23:
                return (R.drawable.occlightsleet);
            case 24:
                return (R.drawable.freezingdrizzle);
            case 29:
                return (R.drawable.partcloudrainthunderday);
            case 38:
                return (R.drawable.modsnow);
            case 39:
                return (R.drawable.blizzard);
            case 45:
                return (R.drawable.fog);
            case 49:
                return (R.drawable.freezingfog);
            case 50:
                return (R.drawable.isorainswrsday);
            case 51:
                return (R.drawable.occlightrain);
            case 56:
                return (R.drawable.freezingdrizzle);
            case 57:
                return (R.drawable.freezingdrizzle);
            case 60:
                return (R.drawable.occlightrain);
            case 61:
                return (R.drawable.modrain);
            case 62:
                return (R.drawable.modrainswrsday);
            case 63:
                return (R.drawable.modrain);
            case 64:
                return (R.drawable.heavyrainswrsday);
            case 65:
                return (R.drawable.heavyrain);
            case 66:
                return (R.drawable.freezingrain);
            case 67:
                return (R.drawable.freezingrain);
            case 68:
                return (R.drawable.modsleet);
            case 69:
                return (R.drawable.heavysleet);
            case 70:
                return (R.drawable.occlightsnow);
            case 71:
                return (R.drawable.occlightsnow);
            case 72:
                return (R.drawable.modsnow);
            case 73:
                return (R.drawable.modsnow);
            case 74:
                return (R.drawable.heavysnowswrsday);
            case 75:
                return (R.drawable.heavysnow);
            case 79:
                return (R.drawable.freezingrain);
            case 80:
                return (R.drawable.isorainswrsday);
            case 81:
                return (R.drawable.modrainswrsday);
            case 82:
                return (R.drawable.heavyrain);
            case 83:
                return (R.drawable.modsleetswrsday);
            case 84:
                return (R.drawable.modsleetswrsday);
            case 85:
                return (R.drawable.isosnowswrsday);
            case 86:
                return (R.drawable.modsnowswrsday);
            case 87:
                return (R.drawable.freezingrain);
            case 88:
                return (R.drawable.freezingrain);
            case 91:
                return (R.drawable.partcloudrainthunderday);
            case 92:
                return (R.drawable.cloudrainthunder);
            case 93:
                return (R.drawable.partcloudsleetsnowthunderday);
            case 94:
                return (R.drawable.cloudsleetsnowthunder);
        }
        return (R.drawable.sunny);
    }

    public static int getNightIcon(String weather) {
        int weatherCode = Integer.parseInt(weather);
        switch (weatherCode) {
            case 0:
                return (R.drawable.clear);
            case 1:
                return (R.drawable.partlycloudynight);
            case 2:
                return (R.drawable.cloudy);
            case 3:
                return (R.drawable.overcast);
            case 10:
                return (R.drawable.mist);
            case 21:
                return (R.drawable.occlightrain);
            case 22:
                return (R.drawable.isosleetswrsnight);
            case 23:
                return (R.drawable.occlightsleet);
            case 24:
                return (R.drawable.freezingdrizzle);
            case 29:
                return (R.drawable.partcloudrainthundernight);
            case 38:
                return (R.drawable.modsnow);
            case 39:
                return (R.drawable.blizzard);
            case 45:
                return (R.drawable.fog);
            case 49:
                return (R.drawable.freezingfog);
            case 50:
                return (R.drawable.isorainswrsnight);
            case 51:
                return (R.drawable.occlightrain);
            case 56:
                return (R.drawable.freezingdrizzle);
            case 57:
                return (R.drawable.freezingdrizzle);
            case 60:
                return (R.drawable.occlightrain);
            case 61:
                return (R.drawable.modrain);
            case 62:
                return (R.drawable.modrainswrsnight);
            case 63:
                return (R.drawable.modrain);
            case 64:
                return (R.drawable.heavyrainswrsnight);
            case 65:
                return (R.drawable.heavyrain);
            case 66:
                return (R.drawable.freezingrain);
            case 67:
                return (R.drawable.freezingrain);
            case 68:
                return (R.drawable.modsleet);
            case 69:
                return (R.drawable.heavysleet);
            case 70:
                return (R.drawable.occlightsnow);
            case 71:
                return (R.drawable.occlightsnow);
            case 72:
                return (R.drawable.modsnow);
            case 73:
                return (R.drawable.modsnow);
            case 74:
                return (R.drawable.heavysnowswrsnight);
            case 75:
                return (R.drawable.heavysnow);
            case 79:
                return (R.drawable.freezingrain);
            case 80:
                return (R.drawable.isorainswrsnight);
            case 81:
                return (R.drawable.modrainswrsnight);
            case 82:
                return (R.drawable.heavyrain);
            case 83:
                return (R.drawable.modsleetswrsnight);
            case 84:
                return (R.drawable.modsleetswrsnight);
            case 85:
                return (R.drawable.isosnowswrsnight);
            case 86:
                return (R.drawable.modsnowswrsnight);
            case 87:
                return (R.drawable.freezingrain);
            case 88:
                return (R.drawable.freezingrain);
            case 91:
                return (R.drawable.partcloudrainthundernight);
            case 92:
                return (R.drawable.cloudrainthunder);
            case 93:
                return (R.drawable.partcloudsleetsnowthundernight);
            case 94:
                return (R.drawable.cloudsleetsnowthunder);
        }
        return (R.drawable.clear);

    }

}
