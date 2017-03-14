package com.myapp.tenortesttask.mvp.presenters;

import com.myapp.tenortesttask.di.AppComponent;
import com.myapp.tenortesttask.mvp.VersionService;
import com.myapp.tenortesttask.mvp.models.Version;
import com.myapp.tenortesttask.mvp.models.VersionManager;
import com.myapp.tenortesttask.mvp.test.TenorTestTaskRunner;
import com.myapp.tenortesttask.mvp.test.TestComponent;
import com.myapp.tenortesttask.mvp.test.TestComponentRule;
import com.myapp.tenortesttask.mvp.views.ListVersionView$$State;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by denishmelinin on 14.03.17.
 */
@RunWith(TenorTestTaskRunner.class)
public class ListVersionPresenterTest {
    @Mock
    VersionService versionService;

    @Rule
    public TestComponentRule testComponentRule = new TestComponentRule(testAppComponent());
    @Mock
    ListVersionView$$State listVersionViewState;

    private ListVersionPresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new ListVersionPresenter();
        presenter.setViewState(listVersionViewState);

        RxJavaPlugins.getInstance().reset();
        RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaSchedulersHook() {
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }
        });
        RxAndroidPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @Test
    public void versions_shouldOnAttachLoadAndShowVersions() {
        VersionManager manager = versionManager();
        when(versionService.getVersionManager()).thenReturn(Observable.just(manager));

        presenter.LoadVersionManager();
        verify(listVersionViewState).LoadVersionManager();
        verify(listVersionViewState).FinishLoadVersionManager();
        verify(listVersionViewState).SuccessLoadVersionManager(manager.getVersions());
    }


    private VersionManager versionManager() {
        VersionManager manager = new VersionManager();

        List<Version> versions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            versions.add(new Version());
        }
        manager.setVersions(versions);
        return manager;
    }

    private AppComponent testAppComponent() {
        return new TestComponent() {
            @Override
            public void inject(ListVersionPresenter presenter) {
                presenter.mVersionService = versionService;
            }
        };
    }
}
