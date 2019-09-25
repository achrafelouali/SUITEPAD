package com.code.suitepad.ui.main;

import com.code.suitepad.data.Model.Pkg;
import com.code.suitepad.ui.base.BaseView;

import java.util.List;


public class MainContract {

    interface View extends BaseView {
        void showPackages(List<Pkg> packages);

        void showErrorMessage();
    }

    interface Presenter {
        void getAllPackages();
    }
}
