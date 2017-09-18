package com.thunderivenstudios.stackoverflowuser.mvp.base.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.thunderivenstudios.stackoverflowuser.R;
import com.thunderivenstudios.stackoverflowuser.mvp.base.presenter.BaseRecyclerViewPresenter;
import com.thunderivenstudios.stackoverflowuser.mvp.base.recycler_view.BaseRecyclerViewAdapter;
import com.thunderivenstudios.stackoverflowuser.mvp.base.view.BaseRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public abstract class BaseRecyclerViewFragment<P extends BaseRecyclerViewPresenter, A extends BaseRecyclerViewAdapter<P>> extends BaseFragment<P> implements BaseRecyclerView {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private A mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = initAdapter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder.add(ButterKnife.bind(this, view));
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = initLayoutManager();
        mRecyclerView.setLayoutManager(layoutManager);
    }

    protected @LayoutRes
    int layoutId() {
        return R.layout.fragment_recycler_view;
    }
    protected abstract A initAdapter();
    protected RecyclerView.LayoutManager initLayoutManager() {
        return new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    }
    protected A getAdapter() {
        return mAdapter;
    }
    protected RecyclerView getRecyclerView() {
        return mRecyclerView;
    }
    //======================================================
    //region BaseRecyclerView
    //======================================================
    @Override
    public void reloadData() {
        if (mAdapter != null && mRecyclerView != null) {
            mRecyclerView.post(() -> mAdapter.notifyDataSetChanged());
        }
    }
    //endregion
}
