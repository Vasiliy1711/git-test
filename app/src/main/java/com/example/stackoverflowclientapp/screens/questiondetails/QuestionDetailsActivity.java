package com.example.stackoverflowclientapp.screens.questiondetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.stackoverflowclientapp.questions.FetchQuestionDetailsUseCase;
import com.example.stackoverflowclientapp.questions.QuestionDetails;
import com.example.stackoverflowclientapp.screens.common.controllers.BaseActivity;
import com.example.stackoverflowclientapp.screens.common.toastshelper.ToastsHelper;

public class QuestionDetailsActivity extends BaseActivity
        implements FetchQuestionDetailsUseCase.Listener, QuestionDetailsViewMvc.Listener
{
    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";

    public static void start(Context context, String questionId)
    {
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(intent);
    }
    private FetchQuestionDetailsUseCase mFetchQuestionDetailsUseCase;
    private ToastsHelper mToastsHelper;
    private QuestionDetailsViewMvc mViewMvc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mFetchQuestionDetailsUseCase = getCompositionRoot().getFetchQuestionDetailsUseCase();
        mToastsHelper = getCompositionRoot().getMessagesDisplayer();
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionDetailsViewMvc(null);
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mFetchQuestionDetailsUseCase.registerListener(this);
        mViewMvc.registerListener(this);
        mViewMvc.showProgressIndication();
        mFetchQuestionDetailsUseCase.fetchQuestionDetailsAndNotify(getQuestionId());

    }

    @Override
    protected void onStop()
    {
        super.onStop();
        mFetchQuestionDetailsUseCase.unregisterListener(this);
        mViewMvc.unregisterListener(this);
    }

    private String getQuestionId()
    {
        return getIntent().getStringExtra(EXTRA_QUESTION_ID);
    }

    private void bindQuestionDetails(QuestionDetails questionDetails)
    {
        mViewMvc.hideProgressIndication();
        mViewMvc.bindQuestion(questionDetails);
    }

    @Override
    public void onQuestionDetailsFetched(QuestionDetails questionDetails)
    {
        bindQuestionDetails(questionDetails);
    }

    @Override
    public void onQuestionDetailsFetchFailed()
    {

        mViewMvc.hideProgressIndication();
        mToastsHelper.showUseCaseError();
    }

    @Override
    public void onNavigateUpClicked()
    {
        onBackPressed();
    }
}
