package com.thunderivenstudios.stackoverflowuser.application;

import android.annotation.SuppressLint;
import android.app.Application;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public class UserApplication extends Application {
    /**
     * This is safe because only 1 instance of Application runs for the entire life cycle of the app
     */
    @SuppressLint("StaticFieldLeak")
    private static Application sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static Application instance() {
        return sApplication;
    }
}
