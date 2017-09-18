package com.thunderivenstudios.stackoverflowuser.api.user;

import com.thunderivenstudios.stackoverflowuser.api.RetrofitFactory;
import com.thunderivenstudios.stackoverflowuser.config.Config;
import com.thunderivenstudios.stackoverflowuser.model.Users;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public class UserRequest {
    private UserRequest() {}

    public static Observable<Users> getUsers() {
        return RetrofitFactory.getRetrofit(Config.BASE_URL)
                .create(UserService.class)
                .getUsers(Config.API_SITE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
