package com.myapp.tenortesttask.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.myapp.tenortesttask.mvp.models.Version;

import java.util.List;

/**
 * Created by denishmelinin on 13.03.17.
 */

public interface ListVersionView extends MvpView {
    void LoadVersionManager();
    void FailedLoadVersionManager(String error);
    void SuccessLoadVersionManager(List<Version> versions);
    void FinishLoadVersionManager();
}
