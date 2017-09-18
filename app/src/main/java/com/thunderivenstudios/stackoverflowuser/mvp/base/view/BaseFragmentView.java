package com.thunderivenstudios.stackoverflowuser.mvp.base.view;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 *
 * Base class for all Fragment View
 */

public interface BaseFragmentView extends BaseView {
    void displayProgressDialog(String message);
    void dismissProgressDialog();
}
