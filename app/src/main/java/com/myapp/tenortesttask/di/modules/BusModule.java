package com.myapp.tenortesttask.di.modules;

import com.myapp.tenortesttask.app.VersionApi;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denishmelinin on 22.02.17.
 */

@Module
public class BusModule {
    @Provides
    @Singleton
    public Bus provideBus(VersionApi versionApi) {
        return new Bus();
    }
}
