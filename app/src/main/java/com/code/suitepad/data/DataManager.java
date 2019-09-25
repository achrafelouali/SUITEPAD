package com.code.suitepad.data;


import com.code.suitepad.data.source.PackageRepository;
import com.code.suitepad.data.source.local.LocalPackageDataSource;


public class DataManager {

    private static DataManager sInstance;

    private DataManager() {
    }

    public static synchronized DataManager getInstance() {
        if (sInstance == null) {
            sInstance = new DataManager();
        }
        return sInstance;
    }


    public PackageRepository getPackageRepository() {
        LocalPackageDataSource packageLocal = LocalPackageDataSource.getInstance();
        return PackageRepository.getInstance(packageLocal);
    }


}
