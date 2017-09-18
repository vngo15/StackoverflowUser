package com.thunderivenstudios.stackoverflowuser.mvp.base.presenter;

import com.thunderivenstudios.stackoverflowuser.model.BaseModel;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public interface BaseRecyclerViewPresenter extends BaseFragmentPresenter {
    int getNumberOfRow();
    BaseModel getModelAtPosition(int section, int row);
    void reloadData();
    void loadMore();
    int getViewHolderViewType(int position);
}
