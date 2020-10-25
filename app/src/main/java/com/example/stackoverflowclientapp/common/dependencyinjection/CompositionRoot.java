package com.example.stackoverflowclientapp.common.dependencyinjection;

import com.example.stackoverflowclientapp.common.Constants;
import com.example.stackoverflowclientapp.networking.StackOverflowApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot
{
    private Retrofit mRetrofit;

    public StackOverflowApi getStackoverflowApi()
    {
        return getRetrofit().create(StackOverflowApi.class);
    }

    private Retrofit getRetrofit()
    {
        if (mRetrofit == null)
        {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
