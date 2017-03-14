package com.myapp.tenortesttask.di;

import android.content.Context;

import com.myapp.tenortesttask.di.modules.BusModule;
import com.myapp.tenortesttask.di.modules.ContextModule;
import com.myapp.tenortesttask.di.modules.VersionModule;
import com.myapp.tenortesttask.mvp.VersionService;
import com.myapp.tenortesttask.mvp.presenters.ListVersionPresenter;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by denishmelinin on 22.02.17.
 */

@Singleton
@Component(modules = {ContextModule.class, BusModule.class, VersionModule.class})
public interface AppComponent {
    Context getContext();
    VersionService getVersionService();
    Bus getBus();


    void inject(ListVersionPresenter presenter);
}
