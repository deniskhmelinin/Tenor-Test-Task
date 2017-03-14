package com.myapp.tenortesttask.app;


import com.myapp.tenortesttask.mvp.models.VersionManager;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by denishmelinin on 13.03.17.
 */

public interface VersionApi
{
        @GET("server_data.txt")
        Observable<VersionManager> getVersionManager();

}
