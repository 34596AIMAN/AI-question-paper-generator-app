package com.myapp.aiqpg.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.myapp.aiqpg.database.entity.NotepadItem;

import java.util.List;

@Dao
public interface NotepadDao {

    @Insert
    void insert(NotepadItem notepadItem);

    @Update
    void update(NotepadItem notepadItem);

    @Delete
    void delete(NotepadItem notepadItem);

    @Query("SELECT * FROM notepad_items ORDER BY created_date DESC")
    LiveData<List<NotepadItem>> getAllNotepadItems();

    @Query("SELECT * FROM notepad_items WHERE id = :id")
    NotepadItem getNotepadItemById(int id);

    @Query("DELETE FROM notepad_items")
    void deleteAll();
}
