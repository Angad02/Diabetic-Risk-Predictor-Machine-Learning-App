package com.example.hp1.deephack;

import android.app.Application;

import timber.log.Timber;

public class DeepHealthApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
