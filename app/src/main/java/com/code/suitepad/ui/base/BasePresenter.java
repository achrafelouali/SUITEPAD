package com.code.suitepad.ui.base;


public abstract class BasePresenter<View extends BaseView> {

    protected View view;

    protected BasePresenter(View view) {
        this.view = view;
    }

    void destroyView() {
        view = null;
    }
}
