package com.thunderivenstudios.stackoverflowuser.mvp.base.presenter;

import com.thunderivenstudios.stackoverflowuser.model.BaseModel;
import com.thunderivenstudios.stackoverflowuser.mvp.base.view.BaseRecyclerView;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public class BaseRecyclerViewPresenterImpl<V extends BaseRecyclerView> extends BaseFragmentPresenterImpl<V> implements BaseRecyclerViewPresenter {
    public BaseRecyclerViewPresenterImpl(V view) {
        super(view);
    }

    //======================================================
    //region BaseRecyclerViewPresenter
    //======================================================
    @Override
    public int getNumberOfRow() {
        return 0;
    }

    @Override
    public BaseModel getModelAtPosition(int section, int row) {
        return null;
    }

    @Override
    public void reloadData() {
        if (getView() != null) {
            getView().dismissProgressDialog();
            getView().reloadData();
        }
    }

    @Override
    public void loadMore(int page) {}

    @Override
    public int getViewHolderViewType(int position) {
        return 0;
    }
    //endregion
}
