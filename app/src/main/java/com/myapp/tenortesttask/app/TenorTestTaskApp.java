package com.myapp.tenortesttask.app;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.myapp.tenortesttask.di.AppComponent;
import com.myapp.tenortesttask.di.DaggerAppComponent;
import com.myapp.tenortesttask.di.modules.ContextModule;


/**
 * Created by denishmelinin on 22.02.17.
 */

public class TenorTestTaskApp extends Application {
    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }


    @VisibleForTesting
    public static void setAppComponent(@NonNull AppComponent appComponent) {
        sAppComponent = appComponent;
    }
}
