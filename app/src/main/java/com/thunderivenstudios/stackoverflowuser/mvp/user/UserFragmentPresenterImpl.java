package com.thunderivenstudios.stackoverflowuser.mvp.user;

import com.thunderivenstudios.stackoverflowuser.api.user.UserRequest;
import com.thunderivenstudios.stackoverflowuser.model.BaseModel;
import com.thunderivenstudios.stackoverflowuser.model.Users;
import com.thunderivenstudios.stackoverflowuser.mvp.base.presenter.BaseRecyclerViewPresenterImpl;
import com.thunderivenstudios.stackoverflowuser.mvp.base.view.BaseRecyclerView;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */

class UserFragmentPresenterImpl extends BaseRecyclerViewPresenterImpl<BaseRecyclerView> {
    private Users mUsers;
    UserFragmentPresenterImpl(BaseRecyclerView view) {
        super(view);
    }

    //=========================================
    //region BaseRecyclerViewPresenter
    //=========================================
    @Override
    public void init() {
        super.init();
        if (getView() != null) getView().displayProgressDialog("loading");
        mDisposable.add(
                UserRequest.getUsers().subscribe(users -> mUsers = users,
                        this::displayError,
                        this::reloadData
                )
        );
    }

    @Override
    public BaseModel getModelAtPosition(int section, int row) {
        return mUsers != null ? mUsers.getUsers().get(row) : super.getModelAtPosition(section, row);
    }

    @Override
    public int getNumberOfRow() {
        return mUsers != null ? mUsers.getUsers().size() : super.getNumberOfRow();
    }
    //endregion
}
