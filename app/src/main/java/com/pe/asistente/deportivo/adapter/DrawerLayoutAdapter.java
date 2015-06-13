package com.pe.asistente.deportivo.adapter;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pe.asistente.deportivo.R;
import com.pe.asistente.deportivo.beans.DrawerLayoutItem;

import java.util.ArrayList;

public class DrawerLayoutAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<DrawerLayoutItem> items;

    public DrawerLayoutAdapter(Activity activity, ArrayList<DrawerLayoutItem> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DrawerLayoutItem item = items.get(position);

        LayoutInflater inflater = (LayoutInflater) this.activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_menu_drawer, null);

        LinearLayout opcion_layout = (LinearLayout) convertView.findViewById(R.id.opcion_layout);
        ImageView imgOpcion = (ImageView) convertView.findViewById(R.id.imgOpcion);
        TextView txtNomOpcion = (TextView) convertView.findViewById(R.id.txtNomOpcion);

        if (item.isSelected()) {
            opcion_layout.setBackgroundColor(activity.getResources().getColor(R.color.plomo));
        } else {
            opcion_layout.setBackgroundColor(activity.getResources().getColor(android.R.color.white));
        }

        imgOpcion.setImageDrawable(activity.getResources().getDrawable(item.iconOpcion()));
        txtNomOpcion.setText(item.nomOpcion());

        return convertView;
    }
}
