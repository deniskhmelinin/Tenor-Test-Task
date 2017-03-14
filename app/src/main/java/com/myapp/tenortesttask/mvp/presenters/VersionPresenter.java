package com.myapp.tenortesttask.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.myapp.tenortesttask.mvp.models.Version;
import com.myapp.tenortesttask.mvp.views.VersionView;

/**
 * Created by denishmelinin on 13.03.17.
 */

@InjectViewState
public class VersionPresenter extends BasePresenter<VersionView> {

    private Version mVersion;

    public VersionPresenter(Version version) {
        super();
        this.mVersion = version;

    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().ShowVersion(mVersion);

    }
}
