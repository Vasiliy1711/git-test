package com.example.stackoverflowclientapp.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.stackoverflowclientapp.screens.common.toolbar.ToolbarViewMvc;
import com.example.stackoverflowclientapp.screens.questiondetails.QuestionDetailsViewMvc;
import com.example.stackoverflowclientapp.screens.questiondetails.QuestionDetailsViewMvcImpl;
import com.example.stackoverflowclientapp.screens.questions_list.questionslistitem.QuestionsListItemViewMvc;
import com.example.stackoverflowclientapp.screens.questions_list.questionslistitem.QuestionsListItemViewMvcImpl;
import com.example.stackoverflowclientapp.screens.questions_list.QuestionsListViewMvc;
import com.example.stackoverflowclientapp.screens.questions_list.QuestionsListViewMvcImpl;

public class ViewMvcFactory
{
    private final LayoutInflater mLayoutInflater;

//
    public ViewMvcFactory(LayoutInflater layoutInflater)
    {
        mLayoutInflater = layoutInflater;
    }

//
    public QuestionsListViewMvc getQuestionsListViewMvc(@Nullable ViewGroup parent)
    {
        return new QuestionsListViewMvcImpl(mLayoutInflater, parent, this);
    }

//
    public QuestionsListItemViewMvc getQuestionsListItemViewMvc(@Nullable ViewGroup parent)
    {
        return new QuestionsListItemViewMvcImpl(mLayoutInflater, parent);
    }

//
    public QuestionDetailsViewMvc getQuestionDetailsViewMvc(ViewGroup parent)
    {
        return new QuestionDetailsViewMvcImpl(mLayoutInflater, parent, this);
    }

    public ToolbarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent)
    {
        return new ToolbarViewMvc(mLayoutInflater, parent);
    }
}
