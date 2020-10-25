package com.example.stackoverflowclientapp.screens.common.controllers;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stackoverflowclientapp.common.CustomApplication;
import com.example.stackoverflowclientapp.common.dependencyinjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity
{
    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot()
    {
        if (mControllerCompositionRoot == null)
        {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication) getApplication()).getCompositionRoot(),
                    this
            );
        }
        return mControllerCompositionRoot;
    }
}
