package com.example.notesapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface NoteDao {
    @Insert
    void insert(NoteEntity note);

    @Update
    void update(NoteEntity note);

    @Query("DELETE FROM notes")
    void deleteAll();

    @Query("DELETE FROM notes WHERE id = :idNote")
    void deleteById(int idNote);

    @Query("SELECT * FROM notes ORDER BY title ASC")
    LiveData<List<NoteEntity>> getAll();

    @Query("SELECT * FROM notes WHERE isFavorite LIKE 'true'")
    LiveData<List<NoteEntity>> getAllFavorites();
}
