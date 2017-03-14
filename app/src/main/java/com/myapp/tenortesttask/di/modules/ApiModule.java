package com.myapp.tenortesttask.di.modules;

import com.myapp.tenortesttask.app.VersionApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by denishmelinin on 13.03.17.
 */

@Module(includes = {RetrofitVersionModule.class})
public class ApiModule {
    @Provides
    @Singleton
    public VersionApi provideVersionApi(Retrofit retrofit) {
        return retrofit.create(VersionApi.class);
    }
}