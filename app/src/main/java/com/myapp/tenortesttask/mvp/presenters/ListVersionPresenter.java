package com.myapp.tenortesttask.mvp.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.myapp.tenortesttask.app.TenorTestTaskApp;
import com.myapp.tenortesttask.mvp.VersionService;
import com.myapp.tenortesttask.mvp.models.Version;
import com.myapp.tenortesttask.mvp.models.VersionManager;
import com.myapp.tenortesttask.mvp.views.ListVersionView;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by denishmelinin on 13.03.17.
 */

@InjectViewState
public class ListVersionPresenter extends BasePresenter<ListVersionView> {

    @Inject
    VersionService mVersionService;

    public ListVersionPresenter() {
        TenorTestTaskApp.getAppComponent().inject(this);
    }

    public void LoadVersionManager()
    {
        getViewState().LoadVersionManager();
        Subscription subscription = mVersionService.getVersionManager()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(manager -> {
                    getViewState().FinishLoadVersionManager();
                    getViewState().SuccessLoadVersionManager(manager.getVersions());

                }, exception -> {
                    getViewState().FinishLoadVersionManager();
                    getViewState().FailedLoadVersionManager(exception.getMessage());
                });

        unsubscribeOnDestroy(subscription);
    }
}
