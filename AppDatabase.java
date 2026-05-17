package com.myapp.aiqpg.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.myapp.aiqpg.database.dao.NotepadDao;
import com.myapp.aiqpg.database.dao.QuestionPaperDao;
import com.myapp.aiqpg.database.entity.NotepadItem;
import com.myapp.aiqpg.database.entity.QuestionPaper;

@Database(entities = {QuestionPaper.class, NotepadItem.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract QuestionPaperDao questionPaperDao();
    public abstract NotepadDao notepadDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "aiqpg_database"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}
