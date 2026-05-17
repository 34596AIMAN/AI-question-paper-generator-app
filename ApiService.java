package com.myapp.aiqpg.network;

import com.myapp.aiqpg.model.ApiResponse;
import com.myapp.aiqpg.model.QuestionPaperRequest;
import com.myapp.aiqpg.model.QuestionPaperResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("api/generate")
    Call<ApiResponse<QuestionPaperResponse>> generateQuestionPaper(@Body QuestionPaperRequest request);
}
