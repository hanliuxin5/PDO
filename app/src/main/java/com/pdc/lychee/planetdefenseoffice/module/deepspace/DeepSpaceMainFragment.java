package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pdc.lychee.planetdefenseoffice.R;
import com.pdc.lychee.planetdefenseoffice.base.fragment.BaseFragment;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPRepository;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote.DPRemoteDataSoucre;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceMainFragment extends BaseFragment implements DeepSpaceMainContact.View {
    private DeepSpaceMainContact.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deepspace, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPresenter = new DeepSpaceMainPrsenter(DPRepository.getInstance(DPRemoteDataSoucre.getInstance()),
                this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showDP() {

    }

    @Override
    public void showLoding() {

    }

    @Override
    public void showLoadError() {

    }

    @Override
    public void showLoadFinish() {

    }

    @Override
    public void showNoDp() {

    }

    @Override
    public void showDPDetails() {

    }

    @Override
    public void showPopUpMenu() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setPresenter(DeepSpaceMainContact.Presenter presenter) {
        if (presenter != null)
            mPresenter = presenter;
    }
}
