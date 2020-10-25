package com.example.stackoverflowclientapp.screens.questiondetails;

import com.example.stackoverflowclientapp.questions.QuestionDetails;
import com.example.stackoverflowclientapp.screens.common.views.ViewMvc;

public interface QuestionDetailsViewMvc extends ViewMvc
{
    void bindQuestion(QuestionDetails question);

    void showProgressIndication();

    void hideProgressIndication();
}
