package com.example.notesapplication;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<NoteEntity>> allNotes;

    public NoteRepository(Application application) {
        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);
        noteDao = db.noteDao();
        allNotes = noteDao.getAll();
    }

    public LiveData<List<NoteEntity>> getAllNotes() {
        return this.allNotes;
    }
}
