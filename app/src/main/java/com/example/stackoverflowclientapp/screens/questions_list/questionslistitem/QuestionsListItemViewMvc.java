package com.example.stackoverflowclientapp.screens.questions_list.questionslistitem;

import com.example.stackoverflowclientapp.questions.Question;
import com.example.stackoverflowclientapp.screens.common.views.ObservableViewMvc;

public interface QuestionsListItemViewMvc extends ObservableViewMvc<QuestionsListItemViewMvc.Listener>
{
    public interface Listener
    {
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);
}
