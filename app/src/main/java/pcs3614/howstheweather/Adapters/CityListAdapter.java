package pcs3614.howstheweather.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import pcs3614.howstheweather.Activities.MainActivity;
import pcs3614.howstheweather.R;
import pcs3614.howstheweather.Utils.Constants;

public class CityListAdapter extends BaseAdapter {
    private Context context;

    public CityListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Constants.LISTA_CIDADES.length;
    }

    @Override
    public Object getItem(int i) {
        return (Constants.LISTA_CIDADES)[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final String cidade = (Constants.LISTA_CIDADES)[i];

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.cell_city, viewGroup, false);

        TextView nomeCidade = (TextView) view.findViewById(R.id.text_view_city);
        nomeCidade.setText(getItem(i).toString());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("cidade", cidade);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
