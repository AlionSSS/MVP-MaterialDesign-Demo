package com.example.materialtest.global;

import android.app.Application;
import android.content.Context;

/**
 * MyApplication
 *
 * @author ALion on 2017/6/26 18:49
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
       super.onCreate();

        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
