package com.myapp.aiqpg.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.myapp.aiqpg.database.entity.QuestionPaper;

import java.util.List;

@Dao
public interface QuestionPaperDao {

    @Insert
    void insert(QuestionPaper questionPaper);

    @Update
    void update(QuestionPaper questionPaper);

    @Delete
    void delete(QuestionPaper questionPaper);

    @Query("SELECT * FROM question_papers ORDER BY created_date DESC")
    LiveData<List<QuestionPaper>> getAllQuestionPapers();

    @Query("SELECT * FROM question_papers WHERE id = :id")
    QuestionPaper getQuestionPaperById(int id);

    @Query("DELETE FROM question_papers")
    void deleteAll();
}
