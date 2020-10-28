package com.example.stackoverflowclientapp.screens.common.navdrawer;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.stackoverflowclientapp.R;
import com.example.stackoverflowclientapp.screens.common.views.BaseObservableViewMvc;
import com.google.android.material.navigation.NavigationView;

public abstract class BaseNavDrawerViewMvc<ListenerType> extends BaseObservableViewMvc<ListenerType>
{
    private final DrawerLayout mDrawerLayout;
    private final FrameLayout mFrameLayout;
    private final NavigationView mNavigationView;

    public BaseNavDrawerViewMvc(LayoutInflater inflater, @Nullable ViewGroup parent)
    {
        super.setRootView(inflater.inflate(R.layout.layout_drawer, parent, false));
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFrameLayout = findViewById(R.id.frame_content);
        mNavigationView = findViewById(R.id.nav_view);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                mDrawerLayout.closeDrawers();
                if(item.getItemId() == R.id.drawer_menu_questions_list)
                {
                    onDrawerItemClicked(DrawerItems.QUESTIONS_LIST);
                }
                return false;
            }
        });

    }

    protected abstract void onDrawerItemClicked(DrawerItems items);

    @Override
    protected void setRootView(View view)
    {
        mFrameLayout.addView(view);
    }
}
