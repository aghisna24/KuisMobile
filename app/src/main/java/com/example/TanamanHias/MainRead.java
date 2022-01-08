package com.example.TanamanHias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import TanamanHias.R;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Tanaman> ListTanaman = new
            ArrayList<Tanaman>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListTanaman
        );
        mListView = (ListView) findViewById(R.id.list_Tanaman);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListTanaman.clear();
        List<Tanaman> Tanaman = db.ReadTanaman();
        for (Tanaman mhs : Tanaman) {
            Tanaman daftar = new Tanaman();
            daftar.set_id(mhs.get_id());
            daftar.set_nama(mhs.get_nama());
            daftar.set_tipe(mhs.get_tipe());
            ListTanaman.add(daftar);if ((ListTanaman.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Tanaman detailMhs = (Tanaman)o;
        String Sid = detailMhs.get_id();
        String Snama = detailMhs.get_nama();
        String Stipe = detailMhs.get_tipe();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Itipe", Stipe);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListTanaman.clear();
        mListView.setAdapter(adapter_off);
        List<Tanaman> Tanaman = db.ReadTanaman();
        for (Tanaman mhs : Tanaman) {
            Tanaman daftar = new Tanaman();
            daftar.set_id(mhs.get_id());
            daftar.set_nama(mhs.get_nama());
            daftar.set_tipe(mhs.get_tipe());
            ListTanaman.add(daftar);
            if ((ListTanaman.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
