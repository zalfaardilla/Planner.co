package com.roomdb.note.main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.roomdb.note.R;
import com.roomdb.note.data.model.Note;
import com.roomdb.note.form.FormActivity;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<Note> notes;

    public MainAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_note, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        final Note note = notes.get(position);
        String tanggal = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(note.getTanggal());

        holder.tvJudul.setText(note.getJudul());
        holder.tvTanggal.setText(tanggal);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FormActivity.class);
                intent.putExtra(FormActivity.NOTE, note);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (notes != null) ? notes.size() : 0;
    }


    class MainViewHolder extends RecyclerView.ViewHolder{
        private TextView tvJudul, tvTanggal;
        private ConstraintLayout layout;

        MainViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
