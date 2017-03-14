package com.myapp.tenortesttask.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.myapp.tenortesttask.mvp.models.Version;

/**
 * Created by denishmelinin on 13.03.17.
 */

public interface VersionView extends MvpView {
    void ShowVersion(Version version);
}
