package com.example.stackoverflowclientapp.common.dependencyinjection;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.example.stackoverflowclientapp.networking.StackOverflowApi;
import com.example.stackoverflowclientapp.questions.FetchLastActiveQuestionsUseCase;
import com.example.stackoverflowclientapp.questions.FetchQuestionDetailsUseCase;
import com.example.stackoverflowclientapp.screens.common.toastshelper.ToastsHelper;
import com.example.stackoverflowclientapp.screens.common.screensnavigator.ScreensNavigator;
import com.example.stackoverflowclientapp.screens.common.ViewMvcFactory;
import com.example.stackoverflowclientapp.screens.questions_list.QuestionsListController;

public class ControllerCompositionRoot
{
    private final CompositionRoot mCompositionRoot;
    private Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity)
    {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    private StackOverflowApi getStackoverflowApi()
    {
        return mCompositionRoot.getStackoverflowApi();
    }

    private LayoutInflater getLayoutInflater()
    {
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory()
    {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase()
    {
        return new FetchQuestionDetailsUseCase(getStackoverflowApi());
    }

    public FetchLastActiveQuestionsUseCase getFetchLastActiveQuestionsUseCase()
    {
        return new FetchLastActiveQuestionsUseCase(getStackoverflowApi());
    }

    public QuestionsListController getQuestionsListController()
    {
        return new QuestionsListController(
                getFetchLastActiveQuestionsUseCase(),
                getScreensNavigator(),
                getMessagesDisplayer()
        );
    }

    private Context getContext()
    {
        return mActivity;
    }

    public ToastsHelper getMessagesDisplayer()
    {
        return new ToastsHelper(getContext());
    }

    private ScreensNavigator getScreensNavigator()
    {
        return new ScreensNavigator(getContext());
    }
}
