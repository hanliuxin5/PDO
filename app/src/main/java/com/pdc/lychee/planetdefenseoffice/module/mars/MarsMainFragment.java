package com.pdc.lychee.planetdefenseoffice.module.mars;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pdc.lychee.planetdefenseoffice.R;
import com.pdc.lychee.planetdefenseoffice.base.fragment.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lychee on 2016/9/8.
 */
public class MarsMainFragment extends BaseFragment implements MarsMainContact.View {


    @Bind(R.id.mars_iv)
    ImageView marsIv;
    @Bind(R.id.mars_tl)
    Toolbar marsTl;
    @Bind(R.id.mars_ap)
    AppBarLayout marsAp;
    @Bind(R.id.in_service_rv)
    RecyclerView inServiceRv;
    @Bind(R.id.retried_rv)
    RecyclerView retriedRv;

    private MarsMainContact.Presenter mPresenter;

    public static MarsMainFragment newInstance() {
        return new MarsMainFragment();
    }

    @Override
    public void setPresenter(MarsMainContact.Presenter presenter) {
        if (presenter != null)
            mPresenter = presenter;
    }

    @Override
    public void initView() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mars, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
