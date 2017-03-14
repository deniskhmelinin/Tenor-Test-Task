package com.myapp.tenortesttask.di.modules;

import com.myapp.tenortesttask.app.VersionApi;
import com.myapp.tenortesttask.mvp.VersionService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by denishmelinin on 13.03.17.
 */

@Module(includes = {ApiModule.class})
public class VersionModule {
    @Provides
    @Singleton
    public VersionService provideVersionService(VersionApi versionApi) {
        return new VersionService(versionApi);
    }
}
