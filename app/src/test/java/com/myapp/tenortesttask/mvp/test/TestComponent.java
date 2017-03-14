package com.myapp.tenortesttask.mvp.test;

import android.content.Context;

import com.myapp.tenortesttask.di.AppComponent;
import com.myapp.tenortesttask.mvp.VersionService;
import com.myapp.tenortesttask.mvp.presenters.ListVersionPresenter;
import com.squareup.otto.Bus;

import org.robolectric.RuntimeEnvironment;

/**
 * Created by denishmelinin on 14.03.17.
 */

public class TestComponent implements AppComponent {
    @Override
    public Context getContext() {
        return RuntimeEnvironment.application;
    }

    @Override
    public VersionService getVersionService() {
        return null;
    }

    @Override
    public Bus getBus() {
        return null;
    }

    @Override
    public void inject(ListVersionPresenter presenter) {

    }
}
