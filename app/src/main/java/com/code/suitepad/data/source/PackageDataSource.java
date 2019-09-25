package com.code.suitepad.data.source;

import com.code.suitepad.data.Model.Pkg;

import java.util.List;


public interface PackageDataSource {

    void getPackages(LoadPackagesCallback callback);

    interface LoadPackagesCallback {
        void onPackagesLoaded(List<Pkg> packages);

        void onError();
    }
}
