package com.example.stackoverflowclientapp.screens.questions_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stackoverflowclientapp.R;
import com.example.stackoverflowclientapp.questions.Question;
import com.example.stackoverflowclientapp.screens.common.toolbar.ToolbarViewMvc;
import com.example.stackoverflowclientapp.screens.common.views.BaseObservableViewMvc;
import com.example.stackoverflowclientapp.screens.common.ViewMvcFactory;

import java.util.List;

public class QuestionsListViewMvcImpl extends BaseObservableViewMvc<QuestionsListViewMvc.Listener>
        implements QuestionsRecyclerAdapter.Listener, QuestionsListViewMvc
{
    private final ToolbarViewMvc mToolbarViewMvc;
    private final Toolbar mToolbar;

    private RecyclerView mRecyclerQuestions;
    private QuestionsRecyclerAdapter mAdapter;
    private final ProgressBar mProgressBar;

    public QuestionsListViewMvcImpl(
            LayoutInflater inflater,
            @Nullable ViewGroup parent,
            ViewMvcFactory viewMvcFactory
    )
    {
        setRootView(inflater.inflate(R.layout.layout_questions_list, parent, false));
        mRecyclerQuestions = findViewById(R.id.recycler_questions);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new QuestionsRecyclerAdapter(this, viewMvcFactory);
        mRecyclerQuestions.setAdapter(mAdapter);
        mProgressBar = findViewById(R.id.progress);

        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        mToolbarViewMvc.setTitle(getString(R.string.questions_list_screen_title));
        mToolbar.addView(mToolbarViewMvc.getRootView());
    }

    @Override
    public void onQuestionClicked(Question question)
    {
        for (Listener listener : getListeners())
        {
            listener.onQuestionClicked(question);
        }
    }

    @Override
    public void bindQuestions(List<Question> questions)
    {

        mAdapter.bindQuestions(questions);
    }

    @Override
    public void showProgressIndication()
    {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndication()
    {
        mProgressBar.setVisibility(View.GONE);
    }
}
