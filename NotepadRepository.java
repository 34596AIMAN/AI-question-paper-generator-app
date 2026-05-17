package com.myapp.aiqpg.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.myapp.aiqpg.database.AppDatabase;
import com.myapp.aiqpg.database.dao.NotepadDao;
import com.myapp.aiqpg.database.entity.NotepadItem;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotepadRepository {

    private final NotepadDao notepadDao;
    private final LiveData<List<NotepadItem>> allNotepadItems;
    private final ExecutorService executorService;

    public NotepadRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        notepadDao = database.notepadDao();
        allNotepadItems = notepadDao.getAllNotepadItems();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<NotepadItem>> getAllNotepadItems() {
        return allNotepadItems;
    }

    public void insert(NotepadItem notepadItem) {
        executorService.execute(() -> notepadDao.insert(notepadItem));
    }

    public void update(NotepadItem notepadItem) {
        executorService.execute(() -> notepadDao.update(notepadItem));
    }

    public void delete(NotepadItem notepadItem) {
        executorService.execute(() -> notepadDao.delete(notepadItem));
    }

    public void deleteAll() {
        executorService.execute(notepadDao::deleteAll);
    }
}
