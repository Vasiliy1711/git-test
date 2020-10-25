package com.example.stackoverflowclientapp.screens.common.screensnavigator;

import android.content.Context;

import com.example.stackoverflowclientapp.screens.questiondetails.QuestionDetailsActivity;

public class ScreensNavigator
{
    private final Context mContext;

    public ScreensNavigator(Context context)
    {
        mContext = context;
    }

    public void toDialogDetails(String questionId)
    {
        QuestionDetailsActivity.start(mContext, questionId);
    }
}
