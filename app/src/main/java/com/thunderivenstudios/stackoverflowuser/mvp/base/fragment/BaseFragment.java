package com.thunderivenstudios.stackoverflowuser.mvp.base.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thunderivenstudios.stackoverflowuser.mvp.base.presenter.BaseFragmentPresenter;
import com.thunderivenstudios.stackoverflowuser.mvp.base.view.BaseFragmentView;

import java.util.HashSet;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public abstract class BaseFragment<P extends BaseFragmentPresenter> extends Fragment implements BaseFragmentView {
    protected ProgressDialog mProgressDialog;
    protected P mPresenter;
    protected HashSet<Unbinder> mUnbinder = new HashSet<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = this.initPresenter();
        //Init ProgressDialog
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(layoutId(), container, false);
        mUnbinder.add(ButterKnife.bind(this, v));
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.destroyed();
    }

    @Override
    public void onDestroyView() {
        for (Unbinder unbinder : mUnbinder) {
            unbinder.unbind();
        }
        mUnbinder.clear();
        super.onDestroyView();
    }

    protected abstract P initPresenter();
    protected abstract @LayoutRes int layoutId();
    protected P getPresenter() {
        return mPresenter;
    }

    //======================================================
    //region BaseFragmentView
    //======================================================
    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog != null) mProgressDialog.dismiss();
    }

    @Override
    public void displayProgressDialog(String message) {
        if (mProgressDialog != null) {
            mProgressDialog.setMessage(message);
            mProgressDialog.show();
        }
    }

    @Override
    public void displayMessage(String title, String message) {
        if (getActivity() != null) {
            new AlertDialog.Builder(getActivity())
                    .setTitle(title)
                    .setMessage(message)
                    .setIcon(0)
                    .show();
        }
    }
    //endregion
}
