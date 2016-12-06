package pcs3614.howstheweather.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import pcs3614.howstheweather.Adapters.CityListAdapter;
import pcs3614.howstheweather.R;

public class CityListAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list_acitivity);

        Context context = this;

        ListView listView = (ListView) findViewById(R.id.list_view_city);
        CityListAdapter cityListAdapter = new CityListAdapter(context);

        listView.setAdapter(cityListAdapter);
    }
}
