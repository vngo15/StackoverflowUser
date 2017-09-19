package com.thunderivenstudios.stackoverflowuser.mvp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.thunderivenstudios.stackoverflowuser.mvp.base.activity.SingleFragmentActivity;
import com.thunderivenstudios.stackoverflowuser.mvp.user.UserFragment;

public class MainActivity extends SingleFragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Stack Overflow Users");
    }

    @Override
    protected Fragment createFragment() {
        return new UserFragment();
    }
}
