package com.roomdb.note.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.roomdb.note.data.model.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM note")
    List<Note> getAll();

    @Insert
    void create(Note note);

    @Delete
    void delete(Note note);
}