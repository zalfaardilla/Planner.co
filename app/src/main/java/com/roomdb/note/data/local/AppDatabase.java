package com.roomdb.note.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.roomdb.note.BuildConfig;
import com.roomdb.note.data.converters.DateConverter;
import com.roomdb.note.data.model.Note;

@Database(entities = {Note.class}, version=1)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();

    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context){
        if (appDatabase == null){
            appDatabase = buildDatabaseInstance(context);
        }
        return appDatabase;
    }

    private static AppDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                BuildConfig.DB_CONSTANT)
                .allowMainThreadQueries().build();
    }

}