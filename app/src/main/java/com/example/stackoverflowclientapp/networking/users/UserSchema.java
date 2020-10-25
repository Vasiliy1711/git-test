package com.example.stackoverflowclientapp.networking.users;

import com.google.gson.annotations.SerializedName;

public class UserSchema
{
    @SerializedName("profile_image")
    private final String mUserAvatarUrl;

    @SerializedName("display_name")
    private final String mUserDisplayName;

    public UserSchema(String mUserAvatarUrl, String mUserDisplayName)
    {
        this.mUserAvatarUrl = mUserAvatarUrl;
        this.mUserDisplayName = mUserDisplayName;
    }

    public String getUserAvatarUrl()
    {
        return mUserAvatarUrl;
    }

    public String getUserDisplayName()
    {
        return mUserDisplayName;
    }
}
