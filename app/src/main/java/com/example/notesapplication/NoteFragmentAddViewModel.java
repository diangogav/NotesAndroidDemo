package com.example.notesapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteFragmentAddViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<NoteEntity>> allNotes;

    public NoteFragmentAddViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }

    LiveData<List<NoteEntity>> getAllNotes() { return allNotes; }

    public void addNote(NoteEntity note) {
        noteRepository.insertNote(note);
    }
}
