package com.thunderivenstudios.stackoverflowuser.api.user;

import com.thunderivenstudios.stackoverflowuser.model.Users;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */

interface UserService {
    @GET("users")
    Observable<Users> getUsers(@Query("site") String site);
}
