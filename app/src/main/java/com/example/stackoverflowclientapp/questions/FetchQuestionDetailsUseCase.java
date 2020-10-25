package com.example.stackoverflowclientapp.questions;

import com.example.stackoverflowclientapp.common.BaseObservable;
import com.example.stackoverflowclientapp.networking.questions.QuestionDetailsResponseSchema;
import com.example.stackoverflowclientapp.networking.questions.QuestionSchema;
import com.example.stackoverflowclientapp.networking.StackOverflowApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionDetailsUseCase extends BaseObservable<FetchQuestionDetailsUseCase.Listener>
{
    private final StackOverflowApi mStackOverflowApi;

    public FetchQuestionDetailsUseCase(StackOverflowApi stackOverflowApi)
    {
        mStackOverflowApi = stackOverflowApi;
    }

    public interface Listener
    {

        void onQuestionDetailsFetched(QuestionDetails questionDetails);

        void onQuestionDetailsFetchFailed();
    }

    public void fetchQuestionDetailsAndNotify(String questionId)
    {
        mStackOverflowApi.fetchQuestionDetails(questionId)
                .enqueue(new Callback<QuestionDetailsResponseSchema>()
                {
                    @Override
                    public void onResponse(Call<QuestionDetailsResponseSchema> call, Response<QuestionDetailsResponseSchema> response)
                    {
                        if (response.isSuccessful())
                        {
                            notifySuccess(response.body().getQuestion());
                        } else
                        {
                            notifyFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionDetailsResponseSchema> call, Throwable t)
                    {
                        notifyFailure();
                    }
                });
    }

    private void notifyFailure()
    {
        for (Listener listener : getListeners())
        {
            listener.onQuestionDetailsFetchFailed();
        }
    }

    private void notifySuccess(QuestionSchema questionSchema)
    {
        for (Listener listener : getListeners())
        {
            listener.onQuestionDetailsFetched(
                    new QuestionDetails(
                            questionSchema.getQuestionId(),
                            questionSchema.getTitle(),
                            questionSchema.getBody()
            ));
        }

    }
}
