package com.thunderivenstudios.stackoverflowuser.mvp.user;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.thunderivenstudios.stackoverflowuser.mvp.base.presenter.BaseRecyclerViewPresenter;
import com.thunderivenstudios.stackoverflowuser.mvp.base.recycler_view.BaseRecyclerViewAdapter;
import com.thunderivenstudios.stackoverflowuser.mvp.base.recycler_view.BaseRecyclerViewHolder;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */

class UserFragmentAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewPresenter> {
    UserFragmentAdapter(@NonNull BaseRecyclerViewPresenter presenter) {
        super(presenter);
    }

    @Override
    public BaseRecyclerViewHolder<BaseRecyclerViewPresenter> onCreateViewHolder(ViewGroup parent, int viewType) {
        return UserFragmentViewHolder.newInstance(parent, getPresenter());
    }
}
