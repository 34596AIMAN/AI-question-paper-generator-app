package com.myapp.aiqpg.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.myapp.aiqpg.database.AppDatabase;
import com.myapp.aiqpg.database.dao.QuestionPaperDao;
import com.myapp.aiqpg.database.entity.QuestionPaper;
import com.myapp.aiqpg.model.ApiResponse;
import com.myapp.aiqpg.model.QuestionPaperRequest;
import com.myapp.aiqpg.model.QuestionPaperResponse;
import com.myapp.aiqpg.network.RetrofitClient;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;

public class QuestionPaperRepository {

    private final QuestionPaperDao questionPaperDao;
    private final LiveData<List<QuestionPaper>> allQuestionPapers;
    private final ExecutorService executorService;

    public QuestionPaperRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        questionPaperDao = database.questionPaperDao();
        allQuestionPapers = questionPaperDao.getAllQuestionPapers();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<QuestionPaper>> getAllQuestionPapers() {
        return allQuestionPapers;
    }

    public void insert(QuestionPaper questionPaper) {
        executorService.execute(() -> questionPaperDao.insert(questionPaper));
    }

    public void update(QuestionPaper questionPaper) {
        executorService.execute(() -> questionPaperDao.update(questionPaper));
    }

    public void delete(QuestionPaper questionPaper) {
        executorService.execute(() -> questionPaperDao.delete(questionPaper));
    }

    public void deleteAll() {
        executorService.execute(questionPaperDao::deleteAll);
    }

    public Call<ApiResponse<QuestionPaperResponse>> generateQuestionPaper(QuestionPaperRequest request) {
        return RetrofitClient.getApiService().generateQuestionPaper(request);
    }
}
