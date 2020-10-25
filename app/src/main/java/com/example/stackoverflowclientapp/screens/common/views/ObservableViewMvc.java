package com.example.stackoverflowclientapp.screens.common.views;

public interface ObservableViewMvc<ListenerType> extends ViewMvc
{
    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);
}
