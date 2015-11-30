package com.example.cassiano.mytestapiapp.navigationDrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.R;

import java.util.List;

/**
 * Created by Cassiano on 30/11/2015.
 */
public class PlanetAdapter extends BaseAdapter {

    private OnPlanetClickedListener listener;
    private List<Planet> planets;

    public PlanetAdapter(Context context, Context listener) {
        try {
            this.listener = (OnPlanetClickedListener) listener;
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        }
        this.planets = Planet.getPlanets(context);
    }

    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int position) {
        return planets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder vh;
        final Planet planet = planets.get(position);

        if (view == null) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.planet_list_item, parent, false);

            vh = new ViewHolder();
            vh.textView = (TextView) view.findViewById(R.id.planet_item);

            vh.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onPlanetClicked(planet);
                    }
                }
            });

            view.setTag(vh);

        } else {
            vh = (ViewHolder) view.getTag();
        }
        vh.textView.setText(planet.getPlanetName());

        return view;
    }

    private static class ViewHolder {
        TextView textView;
    }

    public interface OnPlanetClickedListener {
        void onPlanetClicked(Planet planet);
    }
}
