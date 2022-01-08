package com.example.TanamanHias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import TanamanHias.R;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Etipe;
    private String Snama, Stipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Etipe = (EditText) findViewById(R.id.create_tipe);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Stipe = String.valueOf(Etipe.getText());if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stipe.equals("")) {
                    Etipe.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tipe",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Etipe.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateTanaman(new Tanaman(null, Snama,
                            Stipe));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
