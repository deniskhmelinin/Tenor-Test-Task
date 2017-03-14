package com.myapp.tenortesttask.mvp.presenters;

import com.myapp.tenortesttask.mvp.models.Version;
import com.myapp.tenortesttask.mvp.test.TenorTestTaskRunner;
import com.myapp.tenortesttask.mvp.test.TestComponentRule;
import com.myapp.tenortesttask.mvp.views.VersionView;
import com.myapp.tenortesttask.mvp.views.VersionView$$State;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by denishmelinin on 14.03.17.
 */

@RunWith(TenorTestTaskRunner.class)
public class VersionPresenterTest {

    @Rule
    public TestComponentRule testComponentRule = new TestComponentRule();

    @Mock
    VersionView$$State versionViewState;

    private VersionPresenter presenter;
    private Version version;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        version = new Version();

        presenter = new VersionPresenter(version);
        presenter.setViewState(versionViewState);
    }

    @Test
    public void version_shouldShowVersion() {
        presenter.onFirstViewAttach();
        verify(versionViewState).ShowVersion(version);
    }
}