package com.example.stackoverflowclientapp.screens.questions_list;

import android.os.Bundle;

import com.example.stackoverflowclientapp.screens.common.controllers.BaseActivity;

public class QuestionsListActivity extends BaseActivity
{
    private QuestionsListController mQuestionsListController;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        QuestionsListViewMvc viewMvc = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null);
        mQuestionsListController = getCompositionRoot().getQuestionsListController();
        mQuestionsListController.bindView(viewMvc);
        setContentView(viewMvc.getRootView());

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mQuestionsListController.onStart();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        mQuestionsListController.onStop();
    }


}













//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(httpLoggingInterceptor)
//                .build();