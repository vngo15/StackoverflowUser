package com.thunderivenstudios.stackoverflowuser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */
@SuppressWarnings("unused")
public class User extends BaseModel {
    @SerializedName("badge_counts")
    @Expose
    private Badge mBadge;
    @SerializedName("reputation")
    @Expose
    private long mReputation;
    @SerializedName("profile_image")
    @Expose
    private String mProfileImage;
    @SerializedName("display_name")
    @Expose
    private String mDisplayName;

    public Badge getBadge() {
        return mBadge;
    }

    public long getReputation() {
        return mReputation;
    }

    public String getProfileImage() {
        return mProfileImage;
    }

    public String getDisplayName() {
        return mDisplayName;
    }
}
