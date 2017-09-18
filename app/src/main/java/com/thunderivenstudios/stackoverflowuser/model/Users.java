package com.thunderivenstudios.stackoverflowuser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */
@SuppressWarnings("unused")
public class Users extends BaseModel {
    @SerializedName("items")
    @Expose
    private List<User> mUsers = new ArrayList<>();

    public List<User> getUsers() {
        return mUsers;
    }
}
