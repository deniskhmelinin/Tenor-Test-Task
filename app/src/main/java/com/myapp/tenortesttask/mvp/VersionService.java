package com.myapp.tenortesttask.mvp;

import com.myapp.tenortesttask.app.VersionApi;
import com.myapp.tenortesttask.mvp.models.VersionManager;

import rx.Observable;

/**
 * Created by denishmelinin on 22.02.17.
 */

public class VersionService {
    private VersionApi mVersionApi;

    public VersionService(VersionApi versionApi) {
        mVersionApi = versionApi;
    }

    public Observable<VersionManager> getVersionManager() {
        return mVersionApi.getVersionManager();
    }
}
