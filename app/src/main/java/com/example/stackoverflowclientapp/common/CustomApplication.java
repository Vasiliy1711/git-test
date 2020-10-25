package com.example.stackoverflowclientapp.common;

import android.app.Application;

import com.example.stackoverflowclientapp.common.dependencyinjection.CompositionRoot;


public class CustomApplication extends Application
{
    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot()
    {
        return mCompositionRoot;
    }
}

