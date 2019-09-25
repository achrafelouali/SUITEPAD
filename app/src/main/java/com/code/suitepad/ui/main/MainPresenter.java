package com.code.suitepad.ui.main;

import com.code.suitepad.data.Model.Pkg;
import com.code.suitepad.data.source.PackageDataSource;
import com.code.suitepad.data.source.PackageRepository;
import com.code.suitepad.ui.base.BasePresenter;

import java.util.List;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private final PackageRepository packageRepository;

    public MainPresenter(MainContract.View view, PackageRepository packageRepository) {
        super(view);
        this.packageRepository = packageRepository;
    }

    @Override
    public void getAllPackages() {
        packageRepository.getPackages(new PackageDataSource.LoadPackagesCallback() {
            @Override
            public void onPackagesLoaded(List<Pkg> packages) {
                if (view == null) return;
                view.showPackages(packages);
            }

            @Override
            public void onError() {
                if (view == null) return;
                view.showErrorMessage();
            }
        });
    }
}
