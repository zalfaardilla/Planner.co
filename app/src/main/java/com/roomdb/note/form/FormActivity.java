package com.roomdb.note.form;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.roomdb.note.R;
import com.roomdb.note.data.local.AppDatabase;
import com.roomdb.note.data.model.Note;

import java.util.Date;

public class FormActivity extends AppCompatActivity {
    public static final String NOTE = "NOTE";

    private TextInputEditText etJudul, etCatatan;
    private Note note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Toolbar toolbar = findViewById(R.id.toolbar);
        etJudul = findViewById(R.id.etJudul);
        etCatatan = findViewById(R.id.etCatatan);
        Button btnAction = findViewById(R.id.btnAction);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getSerializable(NOTE) != null){
            note = (Note) extras.getSerializable(NOTE);

            btnAction.setText("HAPUS");
            setTitle(note.getJudul());
            etJudul.setText(note.getJudul());
            etCatatan.setText(note.getCatatan());
            etJudul.setEnabled(false);
            etCatatan.setEnabled(false);

            btnAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppDatabase appDatabase = AppDatabase.getInstance(FormActivity.this);
                    appDatabase.noteDao().delete(note);
                    finish();
                }
            });
        }
        else {
            setTitle("Tambah Note");
            btnAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    note = new Note();
                    note.setJudul(etJudul.getText().toString()+"");
                    note.setCatatan(etCatatan.getText().toString()+"");
                    note.setTanggal(new Date());

                    AppDatabase appDatabase = AppDatabase.getInstance(FormActivity.this);
                    appDatabase.noteDao().create(note);
                    finish();
                }
            });
        }

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
