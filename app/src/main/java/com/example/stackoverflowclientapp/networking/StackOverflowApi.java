package com.example.stackoverflowclientapp.networking;

import com.example.stackoverflowclientapp.networking.questions.QuestionDetailsResponseSchema;
import com.example.stackoverflowclientapp.networking.questions.QuestionsListResponseSchema;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StackOverflowApi
{

    @GET("/questions?sort=activity&order=desc&site=stackoverflow&filter=withbody")
    Call<QuestionsListResponseSchema> fetchLastActiveQuestions(@Query("pagesize") Integer pageSize);

    @GET("/questions/{questionId}?site=stackoverflow&filter=withbody")
    Call<QuestionDetailsResponseSchema> fetchQuestionDetails(@Path("questionId") String questionId);
}
