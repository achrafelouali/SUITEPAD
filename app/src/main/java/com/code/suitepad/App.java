package com.code.suitepad;

import android.app.Application;


/**
 * Created by ELOUALI Achraf on 10/03/2018.
 */
public class App extends Application {

    private static App sInstance;

    private static void init(App app) {
        sInstance = app;
    }

    public static App getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
    }

}
