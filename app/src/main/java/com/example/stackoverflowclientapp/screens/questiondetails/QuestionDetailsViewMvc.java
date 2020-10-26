package com.example.stackoverflowclientapp.screens.questiondetails;

import com.example.stackoverflowclientapp.questions.QuestionDetails;
import com.example.stackoverflowclientapp.screens.common.views.ObservableViewMvc;
import com.example.stackoverflowclientapp.screens.common.views.ViewMvc;

public interface QuestionDetailsViewMvc extends ObservableViewMvc<QuestionDetailsViewMvc.Listener>
{
    public interface Listener
    {
        void onNavigateUpClicked();
    }
    void bindQuestion(QuestionDetails question);

    void showProgressIndication();

    void hideProgressIndication();
}
