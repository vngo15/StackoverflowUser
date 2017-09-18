package com.thunderivenstudios.stackoverflowuser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */
@SuppressWarnings("unused")
public class Badge extends BaseModel {
    @SerializedName("bronze")
    @Expose
    private long mBronzeCount;
    @SerializedName("silver")
    @Expose
    private long mSilverCount;
    @SerializedName("gold")
    @Expose
    private long mGoldCount;

    public long getBronzeCount() {
        return mBronzeCount;
    }

    public long getSilverCount() {
        return mSilverCount;
    }

    public long getGoldCount() {
        return mGoldCount;
    }
}
