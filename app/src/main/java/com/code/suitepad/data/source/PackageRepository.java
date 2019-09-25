package com.code.suitepad.data.source;

import com.code.suitepad.data.Model.Pkg;
import com.code.suitepad.data.source.local.LocalPackageDataSource;

import java.util.List;

public class PackageRepository implements PackageDataSource {


    private static PackageRepository instance;
    private final PackageDataSource packageLocal;

    private PackageRepository(LocalPackageDataSource packageLocal) {
        this.packageLocal = packageLocal;
    }

    public static PackageRepository getInstance(LocalPackageDataSource packageLocal) {
        if (instance == null) {
            instance = new PackageRepository(packageLocal);
        }
        return instance;
    }

    @Override
    public void getPackages(final LoadPackagesCallback callback) {
        if (callback == null) return;

        packageLocal.getPackages(new LoadPackagesCallback() {

            @Override
            public void onPackagesLoaded(List<Pkg> packages) {
                callback.onPackagesLoaded(packages);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }


}
