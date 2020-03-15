package com.example.notesapplication;

import android.app.Application;
import android.os.AsyncTask;

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

    public void insertNote(NoteEntity note) {
        new InsertAsyncTask(noteDao).execute(note);
    }

    private static class InsertAsyncTask extends AsyncTask<NoteEntity, Void, Void> {
        private NoteDao noteDaoAsyncTask;

        InsertAsyncTask(NoteDao dao) {
            noteDaoAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            noteDaoAsyncTask.insert(noteEntities[0]);
            return null;
        }
    }
}
