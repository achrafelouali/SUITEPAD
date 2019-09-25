package com.code.suitepad.data.Model;


import android.graphics.drawable.Drawable;

public class Pkg {

    Drawable icon;
    private String versionName;
    private int versionCode;
    private String name;


    public Pkg(String name, String versionName, int versionCode, Drawable icon) {
        this.name = name;
        this.versionName = versionName;
        this.versionCode = versionCode;
        this.icon = icon;
    }


    public String getVersionName() {
        return versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }


}
