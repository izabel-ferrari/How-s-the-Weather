package pcs3614.howstheweather.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pcs3614.howstheweather.Models.Forecast;
import pcs3614.howstheweather.Models.Weather;
import pcs3614.howstheweather.R;
import pcs3614.howstheweather.Utils.Constants;
import pcs3614.howstheweather.Utils.Formatting;
import pcs3614.howstheweather.WebServices.WebServiceRequest;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String cidadeStr;
    private Context context;
    private Weather weather;
    private Forecast forecast;
    ProgressDialog progressDialog;
    Activity activity = this;

    Toolbar toolbar;
    View cell_today, cell_tomorrow, cell_after_tomorrow;

    TextView textHeaderToday, textTemperatureToday, textDescriptionToday, textHumidityToday, textPressureToday, textWindToday;
    ImageView imageWeatherToday;

    TextView textHeaderTomorrow, textTemperatureDayTomorrow, textDescriptionDayTomorrow, textTemperatureNightTomorrow, textDescriptionNightTomorrow;
    ImageView imageWeatherDayTomorrow, imageWeatherNightTomorrow;

    TextView textHeaderAfterTomorrow, textTemperatureDayAfterTomorrow, textDescriptionAfterTomorrow, textTemperatureNightAfterTomorrow, textDescriptionNightAfterTomorrow;
    ImageView imageWeatherDayAfterTomorrow, imageWeatherNightAfterTomorrow;

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getParcelableExtra("weather") != null) {
                weather = intent.getParcelableExtra("weather");
                populate();
                progressDialog.dismiss();
            } else {
                progressDialog.dismiss();
                showNoInternetDialog();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        cidadeStr = getIntent().getStringExtra("cidade");
        if (cidadeStr == null) {
            cidadeStr = Constants.CIDADE_DEFAULT;
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(cidadeStr);
        setSupportActionBar(toolbar);

        cell_today = findViewById(R.id.include_cell_today);
        cell_tomorrow = findViewById(R.id.include_cell_tomorrow);
        cell_after_tomorrow = findViewById(R.id.include_cell_after_tomorrow);

        textHeaderToday = (TextView) cell_today.findViewById(R.id.text_header);
        imageWeatherToday = (ImageView) cell_today.findViewById(R.id.image_weather);
        textTemperatureToday = (TextView) cell_today.findViewById(R.id.text_temperature);
        textDescriptionToday = (TextView) cell_today.findViewById(R.id.text_description);
        textHumidityToday = (TextView) cell_today.findViewById(R.id.text_humidity);
        textPressureToday = (TextView) cell_today.findViewById(R.id.text_pressure);
        textWindToday = (TextView) cell_today.findViewById(R.id.text_wind);

        textHeaderTomorrow = (TextView) cell_tomorrow.findViewById(R.id.text_header);
        imageWeatherDayTomorrow = (ImageView) cell_tomorrow.findViewById(R.id.image_weather_day);
        textTemperatureDayTomorrow = (TextView) cell_tomorrow.findViewById(R.id.text_temperature_day);
        textDescriptionDayTomorrow = (TextView) cell_tomorrow.findViewById(R.id.text_description_day);
        imageWeatherNightTomorrow = (ImageView) cell_tomorrow.findViewById(R.id.image_weather_night);
        textTemperatureNightTomorrow = (TextView) cell_tomorrow.findViewById(R.id.text_temperature_night);
        textDescriptionNightTomorrow = (TextView) cell_tomorrow.findViewById(R.id.text_description_night);

        textHeaderAfterTomorrow = (TextView) cell_after_tomorrow.findViewById(R.id.text_header);
        imageWeatherDayAfterTomorrow = (ImageView) cell_after_tomorrow.findViewById(R.id.image_weather_day);
        textTemperatureDayAfterTomorrow = (TextView) cell_after_tomorrow.findViewById(R.id.text_temperature_day);
        textDescriptionAfterTomorrow = (TextView) cell_after_tomorrow.findViewById(R.id.text_description_day);
        imageWeatherNightAfterTomorrow = (ImageView) cell_after_tomorrow.findViewById(R.id.image_weather_night);
        textTemperatureNightAfterTomorrow = (TextView) cell_after_tomorrow.findViewById(R.id.text_temperature_night);
        textDescriptionNightAfterTomorrow = (TextView) cell_after_tomorrow.findViewById(R.id.text_description_night);

        if (isNetworkAvailable()) {
            getForecast(cidadeStr);
        } else {
            showNoInternetDialog();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(activity, CityListAcitivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(Constants.BROADCAST_WEATHER));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    private void showNoInternetDialog() {
        new AlertDialog.Builder(context)
                .setTitle("Sem conexão à internet")
                .setMessage("Verifique sua conexão e tente novamente.")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void getForecast(String cidade) {
        WebServiceRequest webServiceRequest = new WebServiceRequest();
        webServiceRequest.getForecast(context, cidade);
        progressDialog = ProgressDialog.show(context, null, "Carregando...");
    }

    private void populate() {
        if (weather != null) {
            textHeaderToday.setText(Formatting.getCurrentDate());
            imageWeatherToday.setImageResource(Formatting.getDayIcon(weather.getCurrenWeather().getWeatherCode()));
            textTemperatureToday.setText(Formatting.getTemperature(weather.getCurrenWeather().getTemp()));
            textDescriptionToday.setText(Formatting.getDescription(weather.getCurrenWeather().getWeatherCode()));
            textHumidityToday.setText(Formatting.getHumidity(weather.getCurrenWeather().getHumidity()));
            textPressureToday.setText(Formatting.getPressure(weather.getCurrenWeather().getPressure()));
            textWindToday.setText(Formatting.getWind(weather.getCurrenWeather().getWind().getSpeed()));

            forecast = weather.getForecastList().get(0);
            //textHeaderTomorrow.setText(Formatting.getDate(forecast.getDate()));
            textHeaderTomorrow.setText(R.string.amanha);
            imageWeatherDayTomorrow.setImageResource(Formatting.getDayIcon(forecast.getDay().getWeatherCode()));
            textTemperatureDayTomorrow.setText(Formatting.getTemperature(forecast.getDayMaxTemp()));
            textDescriptionDayTomorrow.setText(Formatting.getDescription(forecast.getDay().getWeatherCode()));
            imageWeatherNightTomorrow.setImageResource(Formatting.getNightIcon(forecast.getNight().getWeatherCode()));
            textTemperatureNightTomorrow.setText(Formatting.getTemperature(forecast.getNightMinTemp()));
            textDescriptionNightTomorrow.setText(Formatting.getDescription(forecast.getNight().getWeatherCode()));

            forecast = weather.getForecastList().get(1);
            //textHeaderAfterTomorrow.setText(Formatting.getDate(forecast.getDate()));
            textHeaderAfterTomorrow.setText(R.string.depois_amanha);
            imageWeatherDayAfterTomorrow.setImageResource(Formatting.getDayIcon(forecast.getDay().getWeatherCode()));
            textTemperatureDayAfterTomorrow.setText(Formatting.getTemperature(forecast.getDayMaxTemp()));
            textDescriptionAfterTomorrow.setText(Formatting.getDescription(forecast.getDay().getWeatherCode()));
            imageWeatherNightAfterTomorrow.setImageResource(Formatting.getNightIcon(forecast.getNight().getWeatherCode()));
            textTemperatureNightAfterTomorrow.setText(Formatting.getTemperature(forecast.getNightMinTemp()));
            textDescriptionNightAfterTomorrow.setText(Formatting.getDescription(forecast.getNight().getWeatherCode()));
        }
    }
}
