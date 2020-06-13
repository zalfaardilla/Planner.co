package com.roomdb.note.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.roomdb.note.R;
import com.roomdb.note.data.local.AppDatabase;
import com.roomdb.note.data.model.Note;
import com.roomdb.note.form.FormActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MainAdapter adapter;
    private ArrayList<Note> notes = new ArrayList<>();
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Note");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        appDatabase = AppDatabase.getInstance(this);
        adapter = new MainAdapter(notes);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        notes.clear();
        notes.addAll(appDatabase.noteDao().getAll());
        adapter.notifyDataSetChanged();
    }
}
