package com.example.stackoverflowclientapp.questions;

import com.example.stackoverflowclientapp.common.BaseObservable;
import com.example.stackoverflowclientapp.common.Constants;
import com.example.stackoverflowclientapp.networking.questions.QuestionSchema;
import com.example.stackoverflowclientapp.networking.questions.QuestionsListResponseSchema;
import com.example.stackoverflowclientapp.networking.StackOverflowApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchLastActiveQuestionsUseCase extends BaseObservable<FetchLastActiveQuestionsUseCase.Listener>
{
    public interface Listener
    {

        void onLastActiveQuestionFetched(List<Question> questions);
        void onLastActiveQuestionFetchFailed();
    }
    private final StackOverflowApi mStackOverflowApi;

    public FetchLastActiveQuestionsUseCase(StackOverflowApi stackOverflowApi)
    {
        mStackOverflowApi = stackOverflowApi;
    }

    public void fetchLastActiveQuestionAndNotify()
    {
        mStackOverflowApi.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
                .enqueue(new Callback<QuestionsListResponseSchema>()
                {
                    @Override
                    public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response)
                    {
                        if (response.isSuccessful())
                        {
                            notifySuccess(response.body().getQuestionSchemas());
                        } else
                        {
                            notifyFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t)
                    {
                        notifyFailure();
                    }
                });
    }

    private void notifyFailure()
    {
        for (Listener listener : getListeners())
        {
            listener.onLastActiveQuestionFetchFailed();
        }
    }

    private void notifySuccess(List<QuestionSchema> questionSchemas)
    {
        List<Question> questions = new ArrayList<>(questionSchemas.size());
        for (QuestionSchema questionSchema : questionSchemas)
        {
            questions.add(new Question(questionSchema.getQuestionId(), questionSchema.getTitle()));
        }

        for (Listener listener : getListeners())
        {
            listener.onLastActiveQuestionFetched(questions);
        }
    }
}
