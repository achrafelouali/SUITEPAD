package com.code.suitepad.data.source.local;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import com.code.suitepad.App;
import com.code.suitepad.data.Model.Pkg;
import com.code.suitepad.data.source.PackageDataSource;

import java.util.ArrayList;
import java.util.List;


public class LocalPackageDataSource implements PackageDataSource {

    private static LocalPackageDataSource instance;

    public static LocalPackageDataSource getInstance() {
        if (instance == null) {
            instance = new LocalPackageDataSource();
        }
        return instance;
    }

    @Override
    public void getPackages(final LoadPackagesCallback callback) {
        List<Pkg> packages = new ArrayList<>();
        Drawable PackageIcon = null;

        PackageManager pm = App.getInstance().getPackageManager();
        for (PackageInfo packageInfo : pm.getInstalledPackages(PackageManager.GET_META_DATA)) {
            try {
                PackageIcon = pm.getApplicationIcon(packageInfo.packageName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            packages.add(new Pkg(packageInfo.packageName, packageInfo.versionName, packageInfo.versionCode, PackageIcon));
        }

        callback.onPackagesLoaded(packages);
    }


}
