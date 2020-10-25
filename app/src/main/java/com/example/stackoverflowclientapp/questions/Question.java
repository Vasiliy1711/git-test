package com.example.stackoverflowclientapp.questions;

public class Question
{
    private final String mId;
    private final String mTitle;

    public Question(String id, String title)
    {
        this.mId = id;
        this.mTitle = title;
    }

    public String getId()
    {
        return mId;
    }

    public String getTitle()
    {
        return mTitle;
    }
}
