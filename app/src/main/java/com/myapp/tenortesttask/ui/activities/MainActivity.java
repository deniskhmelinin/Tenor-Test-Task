package com.myapp.tenortesttask.ui.activities;

import android.os.Bundle;
import android.widget.ListView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.myapp.tenortesttask.R;
import com.myapp.tenortesttask.mvp.models.Version;
import com.myapp.tenortesttask.mvp.presenters.ListVersionPresenter;
import com.myapp.tenortesttask.mvp.views.ListVersionView;
import com.myapp.tenortesttask.ui.adapters.ListVersionAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity {


    @BindView(R.id.versionListView)
    ListView mVersionListView;

    private ListVersionAdapter mListVersionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getMvpDelegate().onAttach();

        mListVersionAdapter = new ListVersionAdapter(getMvpDelegate());
        mVersionListView.setAdapter(mListVersionAdapter);
    }

}
