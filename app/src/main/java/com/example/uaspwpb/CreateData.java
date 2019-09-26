package com.example.uaspwpb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateData extends AppCompatActivity {

    protected Cursor cursor;
    DatabaseHelper dbHelper;
    Button btnSimpan;
    EditText txtJudul, txtDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_data);

        dbHelper = new DatabaseHelper(this);
        txtJudul = (EditText) findViewById(R.id.judul);
        txtDeskripsi = (EditText) findViewById(R.id.deskripsi);
        btnSimpan = (Button) findViewById(R.id.button);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into mapel(nama_judul, deskripsi) values('" +
                        txtJudul.getText().toString() + "','" +
                        txtDeskripsi.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}
