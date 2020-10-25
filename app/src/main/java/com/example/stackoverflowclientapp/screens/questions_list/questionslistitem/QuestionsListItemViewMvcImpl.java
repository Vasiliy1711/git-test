package com.example.stackoverflowclientapp.screens.questions_list.questionslistitem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stackoverflowclientapp.R;
import com.example.stackoverflowclientapp.questions.Question;
import com.example.stackoverflowclientapp.screens.common.views.BaseObservableViewMvc;

public class QuestionsListItemViewMvcImpl extends BaseObservableViewMvc<QuestionsListItemViewMvc.Listener>
        implements QuestionsListItemViewMvc
{


    private Question mQuestion;
    private final TextView mTxtTitle;

    public QuestionsListItemViewMvcImpl(LayoutInflater inflater, ViewGroup parent)
    {
        setRootView(inflater.inflate(R.layout.layout_question_list_item, parent, false));
        mTxtTitle = findViewById(R.id.txt_title);
        getRootView().setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                for (Listener listener : getListeners())
                {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });
    }

    @Override
    public void bindQuestion(Question question)
    {
        mQuestion = question;
        mTxtTitle.setText(question.getTitle());
    }

}
