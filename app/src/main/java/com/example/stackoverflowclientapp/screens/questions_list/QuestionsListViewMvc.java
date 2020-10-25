package com.example.stackoverflowclientapp.screens.questions_list;

import com.example.stackoverflowclientapp.questions.Question;
import com.example.stackoverflowclientapp.screens.common.views.ObservableViewMvc;

import java.util.List;

public interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener>
{
    public interface Listener
    {
        void onQuestionClicked(Question question);
    }

    void bindQuestions(List<Question> questions);
    void showProgressIndication();
    void hideProgressIndication();
}
