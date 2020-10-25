package com.example.stackoverflowclientapp.networking.questions;

import com.example.stackoverflowclientapp.networking.users.UserSchema;
import com.google.gson.annotations.SerializedName;

public class QuestionSchema
{
    @SerializedName("title")
    private final String mTitle;

    @SerializedName("question_id")
    private final String mQuestionId;

    @SerializedName("body")
    private final String mBody;

    @SerializedName("owner")
    private final UserSchema mOwner;

    public QuestionSchema(String title, String id, String body, UserSchema owner)
    {
        mTitle = title;
        mQuestionId = id;
        mBody = body;
        mOwner = owner;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public String getQuestionId()
    {
        return mQuestionId;
    }

    public String getBody()
    {
        return mBody;
    }

    public UserSchema getOwner()
    {
        return mOwner;
    }
}

