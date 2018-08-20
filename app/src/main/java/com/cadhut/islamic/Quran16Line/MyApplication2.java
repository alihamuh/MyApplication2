package com.cadhut.islamic.Quran16Line;

import android.app.Application;
import android.content.Context;

public class MyApplication2 extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication2.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication2.context;
    }
}
