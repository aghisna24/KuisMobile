package com.example.TanamanHias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import TanamanHias.R;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Stipe;
    private EditText Enama, Etipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Stipe = i.getStringExtra("Itipe");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Etipe = (EditText) findViewById(R.id.updel_tipe);
        Enama.setText(Snama);
        Etipe.setText(Stipe);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Stipe = String.valueOf(Etipe.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Stipe.equals("")){
                    Etipe.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tipe",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateTanaman(new Tanaman(Sid, Snama,
                            Stipe));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteTanaman(new Tanaman(Sid, Snama,
                        Stipe));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
