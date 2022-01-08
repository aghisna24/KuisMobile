package com.example.TanamanHias;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import TanamanHias.R;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Tanaman> Tanaman;
    public CustomListAdapter(Activity activity, List<Tanaman>
            Tanaman) {
        this.activity = activity;
        this.Tanaman = Tanaman;
    }
    @Override
    public int getCount() {return Tanaman.size();
    }
    @Override
    public Object getItem(int location) {
        return Tanaman.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView tipe = (TextView)
                convertView.findViewById(R.id.text_tipe);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Tanaman m = Tanaman.get(position);
        nama.setText("Nama : "+ m.get_nama());
        tipe.setText("Kelas : "+ m.get_tipe());
        return convertView;
    }
}
