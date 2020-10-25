package com.example.stackoverflowclientapp.questions;

import android.app.Application;

import com.example.stackoverflowclientapp.common.dependencyinjection.CompositionRoot;

public class QuestionDetails
{
    private final String mId;
    private final String mTitle;
    private final String mBody;

    public QuestionDetails(String mId, String mTitle, String mBody)
    {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mBody = mBody;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public String getBody()
    {
        return mBody;
    }

    public String getId()
    {
        return mId;
    }

}
