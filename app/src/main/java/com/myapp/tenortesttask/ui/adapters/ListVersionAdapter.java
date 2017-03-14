package com.myapp.tenortesttask.ui.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.myapp.tenortesttask.R;
import com.myapp.tenortesttask.app.TenorTestTaskApp;
import com.myapp.tenortesttask.mvp.models.Version;
import com.myapp.tenortesttask.mvp.presenters.ListVersionPresenter;
import com.myapp.tenortesttask.mvp.presenters.VersionPresenter;
import com.myapp.tenortesttask.mvp.views.ListVersionView;
import com.myapp.tenortesttask.mvp.views.VersionView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by denishmelinin on 13.03.17.
 */

public class ListVersionAdapter extends MvpBaseAdapter implements ListVersionView {

    @InjectPresenter
    ListVersionPresenter mListVersionPresenter;

    private List<Version> mVersions;

    public ListVersionAdapter(MvpDelegate<?> parentDelegate) {
        super(parentDelegate, String.valueOf(0));
        mVersions = new ArrayList<>();
        mListVersionPresenter.LoadVersionManager();
    }

    @Override
    public int getCount() {
        return mVersions.size();
    }

    @Override
    public Version getItem(int position) {
        return mVersions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListVersionHolder holder;
        if (convertView != null) {
            holder = (ListVersionHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.version_layout, parent, false);
            holder = new ListVersionHolder(convertView);
            convertView.setTag(holder);
        }

        final Version item = getItem(position);

        holder.bind(position, item);

        return convertView;
    }

    @Override
    public void LoadVersionManager() {
        Log.d("DayWeekBookAdapter", "Load Books");
    }

    @Override
    public void SuccessLoadVersionManager(List<Version> versions) {
        mVersions = new ArrayList<>(versions);
        notifyDataSetChanged();
    }

    @Override
    public void FailedLoadVersionManager(String error) {
        Log.d("ListVersionAdapter", error);
    }

    @Override
    public void FinishLoadVersionManager() {

    }
    public class ListVersionHolder implements VersionView {
        @InjectPresenter
        VersionPresenter mVersionPresenter;

        private Version mVersion;

        @BindView(R.id.name_version)
        TextView name_version;

        @BindView(R.id.number_version)
        TextView number_version;

        @BindView(R.id.icon_version)
        ImageView icon_version;

        View view;

        private MvpDelegate mMvpDelegate;

        @ProvidePresenter
        VersionPresenter provideVersionPresenter() {
            return new VersionPresenter(mVersion);
        }

        ListVersionHolder(View view) {
            this.view = view;

            ButterKnife.bind(this, view);

        }

        void bind(int position, Version version) {
            if (getMvpDelegate() != null) {
                getMvpDelegate().onSaveInstanceState();
                getMvpDelegate().onDetach();
                getMvpDelegate().onDestroyView();
                mMvpDelegate = null;
            }

            mVersion = version;

            getMvpDelegate().onCreate();
            getMvpDelegate().onAttach();
        }

        @Override
        public void ShowVersion(Version version) {
            name_version.setText(version.getName());
            number_version.setText(version.getVersion().toString());
            Picasso.with(TenorTestTaskApp.getAppComponent().getContext()).load(version.getImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(icon_version);
        }


        MvpDelegate getMvpDelegate() {
            if (mVersion == null) {
                return null;
            }

            if (mMvpDelegate == null) {
                mMvpDelegate = new MvpDelegate<>(this);
                mMvpDelegate.setParentDelegate(ListVersionAdapter.this.getMvpDelegate(), String.valueOf(mVersion.getId()));

            }
            return mMvpDelegate;
        }
    }
}
