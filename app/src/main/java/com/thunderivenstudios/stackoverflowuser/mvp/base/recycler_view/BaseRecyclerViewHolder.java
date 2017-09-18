package com.thunderivenstudios.stackoverflowuser.mvp.base.recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.thunderivenstudios.stackoverflowuser.mvp.base.presenter.BaseRecyclerViewPresenter;
import com.thunderivenstudios.stackoverflowuser.mvp.base.view.BaseRecyclerView;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public class BaseRecyclerViewHolder<P extends BaseRecyclerViewPresenter> extends RecyclerView.ViewHolder {
    private P mPresenter;

    public BaseRecyclerViewHolder(View itemView, P presenter) {
        super(itemView);
        mPresenter = presenter;
    }

    protected P getPresenter() {
        return mPresenter;
    }

    public void loadData(int position) {}
    protected Context getContext() {
        return itemView.getContext();
    }
}
