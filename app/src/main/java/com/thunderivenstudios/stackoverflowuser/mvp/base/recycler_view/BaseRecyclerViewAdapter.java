package com.thunderivenstudios.stackoverflowuser.mvp.base.recycler_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.thunderivenstudios.stackoverflowuser.mvp.base.presenter.BaseRecyclerViewPresenter;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public abstract class BaseRecyclerViewAdapter<P extends BaseRecyclerViewPresenter> extends RecyclerView.Adapter<BaseRecyclerViewHolder<P>> {
    private P mPresenter;

    public BaseRecyclerViewAdapter(@NonNull P presenter) {
        mPresenter = presenter;
    }

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder<P> holder, int position) {
        holder.loadData(position);
        //pagination
        if (position == mPresenter.getNumberOfRow() - 1) {
            mPresenter.loadMore();
        }
    }

    @Override
    public int getItemCount() {
        return mPresenter.getNumberOfRow();
    }

    @Override
    public int getItemViewType(int position) {
        return mPresenter.getViewHolderViewType(position);
    }
}
