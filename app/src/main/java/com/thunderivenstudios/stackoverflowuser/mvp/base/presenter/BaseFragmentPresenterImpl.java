package com.thunderivenstudios.stackoverflowuser.mvp.base.presenter;

import com.thunderivenstudios.stackoverflowuser.mvp.base.view.BaseFragmentView;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 */

public class BaseFragmentPresenterImpl<V extends BaseFragmentView> extends BasePresenterImpl<V> implements BaseFragmentPresenter {
    public BaseFragmentPresenterImpl(V view) {
        super(view);
    }
}
