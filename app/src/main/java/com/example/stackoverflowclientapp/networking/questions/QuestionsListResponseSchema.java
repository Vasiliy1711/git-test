package com.example.stackoverflowclientapp.networking.questions;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsListResponseSchema
{
    @SerializedName("items")
    private  final List<QuestionSchema> questionSchemas;

    public QuestionsListResponseSchema(List<QuestionSchema> questionSchemas)
    {
        this.questionSchemas = questionSchemas;
    }

    public List<QuestionSchema> getQuestionSchemas()
    {
        return questionSchemas;
    }
}
