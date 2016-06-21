package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pdc.lychee.planetdefenseoffice.R;
import com.pdc.lychee.planetdefenseoffice.base.fragment.BaseFragment;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPRepository;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote.DPRemoteDataSoucre;
import com.pdc.lychee.planetdefenseoffice.utils.LogUtil;
import com.pdc.lychee.planetdefenseoffice.utils.TestWrapContentLinearLayoutManager;
import com.pdc.lychee.planetdefenseoffice.utils.ToastUtil;
import com.pdc.lychee.planetdefenseoffice.view.ErrorLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceMainFragment extends BaseFragment implements DeepSpaceMainContact.View,
        SwipeRefreshLayout.OnRefreshListener, ErrorLayout.OnFailedClickListener,
        DeepSpaceAdapter.OnLoadingListener {
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.refresh_swipe)
    SwipeRefreshLayout refreshSwipe;
    @Bind(R.id.error_frame)
    ErrorLayout errorFrame;

    private DeepSpaceMainContact.Presenter mPresenter;
    private DeepSpaceAdapter deepSpaceAdapter;

    public static DeepSpaceMainFragment newInstance() {
        return new DeepSpaceMainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deepspace, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPresenter = new DeepSpaceMainPresenter(DPRepository.getInstance(DPRemoteDataSoucre.getInstance()),
                this);
        refreshSwipe.setColorSchemeResources(
                R.color.swipe_refresh_first, R.color.swipe_refresh_second,
                R.color.swipe_refresh_third, R.color.swipe_refresh_four
        );
        refreshSwipe.setOnRefreshListener(this);
        errorFrame.setOnFailedClickListener(this);

        TestWrapContentLinearLayoutManager testWrapContentLinearLayoutManager = new TestWrapContentLinearLayoutManager(mContext);
        testWrapContentLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        deepSpaceAdapter = new DeepSpaceAdapter(mContext, new ArrayList<DeepSpaceBean>(), DeepSpaceAdapter.ONLY_FOOTER);
        deepSpaceAdapter.setOnLoadingListener(this);

        recyclerView.setLayoutManager(testWrapContentLinearLayoutManager);
        recyclerView.setItemAnimator(defaultItemAnimator);
        recyclerView.setAdapter(deepSpaceAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showDP(DeepSpaceBean deepSpaceBean) {
        LogUtil.i(deepSpaceBean.getUrl());
        deepSpaceAdapter.addItem(deepSpaceBean);
    }

    @Override
    public void showLoading() {
        if (deepSpaceAdapter.getDataSize() == 0) {
            errorFrame.setState(ErrorLayout.LOADING);
        }
    }

    @Override
    public void showLoadError() {
        refreshSwipe.setEnabled(true);
        refreshSwipe.setRefreshing(false);
        mState = STATE_NONE;
        if (deepSpaceAdapter.getDataSize() > 0) {
            ToastUtil.toast("数据加载失败！");
        } else {
            errorFrame.setState(ErrorLayout.LOAD_FAILED);
        }
    }

    @Override
    public void showLoadFinish() {
        refreshSwipe.setRefreshing(false);
        refreshSwipe.setEnabled(true);
        errorFrame.setState(ErrorLayout.HIDE);
        mState = STATE_NONE;
    }

    @Override
    public void showNoDp() {
        errorFrame.setState(ErrorLayout.EMPTY_DATA);
        deepSpaceAdapter.setState(deepSpaceAdapter.STATE_HIDE);

    }

    @Override
    public void showNoMoreDP() {
        errorFrame.setState(ErrorLayout.HIDE);
        deepSpaceAdapter.setState(deepSpaceAdapter.STATE_NO_MORE);
    }

    @Override
    public void showDPDetails() {
        //进入dp详情
    }


    @Override
    public void setPresenter(DeepSpaceMainContact.Presenter presenter) {
        if (presenter != null)
            mPresenter = presenter;
    }

    @Override
    public void onLoadFailedClick() {
        errorFrame.setState(ErrorLayout.LOADING);
        //重新加载
    }

    @Override
    public void onLoading() {
        if (mState == STATE_REFRESHING) {
            deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_REFRESHING);
            return;
        }
        deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_LOADING);
        //加载更多

    }

    @Override
    public void onRefresh() {
        if (mState == STATE_REFRESHING)
            return;
        mState = STATE_REFRESHING;
        refreshSwipe.setRefreshing(true);
        refreshSwipe.setEnabled(false);
        //刷新加载

    }
}
