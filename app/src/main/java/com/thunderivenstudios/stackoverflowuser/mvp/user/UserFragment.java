package com.thunderivenstudios.stackoverflowuser.mvp.user;

import com.thunderivenstudios.stackoverflowuser.mvp.base.fragment.BaseRecyclerViewFragment;
import com.thunderivenstudios.stackoverflowuser.mvp.base.presenter.BaseRecyclerViewPresenter;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public class UserFragment extends BaseRecyclerViewFragment<BaseRecyclerViewPresenter, UserFragmentAdapter> {
    @Override
    protected UserFragmentAdapter initAdapter() {
        return new UserFragmentAdapter(getPresenter());
    }

    @Override
    protected BaseRecyclerViewPresenter initPresenter() {
        return new UserFragmentPresenterImpl(this);
    }
}
