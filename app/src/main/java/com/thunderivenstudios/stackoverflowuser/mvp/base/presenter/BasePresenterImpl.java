package com.thunderivenstudios.stackoverflowuser.mvp.base.presenter;

import com.thunderivenstudios.stackoverflowuser.mvp.base.view.BaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */
@SuppressWarnings("all")
public abstract class BasePresenterImpl<V extends BaseView> implements BasePresenter {
    private WeakReference<V> mView;
    protected CompositeDisposable mDisposable = new CompositeDisposable();

    public BasePresenterImpl(V view) {
        mView = new WeakReference<>(view);
    }

    protected V getView() {
        if (mView != null) {
            return mView.get();
        }
        return null;
    }

    @Override
    public void init() {
        if (mDisposable == null) {
            mDisposable = new CompositeDisposable();
        }
    }

    @Override
    public void destroyed() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
