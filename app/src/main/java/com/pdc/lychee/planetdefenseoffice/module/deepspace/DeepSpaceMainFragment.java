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

import com.pdc.lychee.planetdefenseoffice.R;
import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.base.fragment.BaseFragment;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPRepository;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.local.DPLocalDataSource;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote.DPRemoteDataSource;
import com.pdc.lychee.planetdefenseoffice.utils.TestWrapContentLinearLayoutManager;
import com.pdc.lychee.planetdefenseoffice.utils.ToastUtil;
import com.pdc.lychee.planetdefenseoffice.view.ErrorLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceMainFragment extends BaseFragment implements DeepSpaceMainContact.View {

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deepSpaceAdapter = new DeepSpaceAdapter(mContext, new ArrayList<DeepSpaceBean>(), DeepSpaceAdapter.ONLY_FOOTER);
        setRetainInstance(true);
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
        mPresenter = new DeepSpaceMainPresenter(DPRepository.getInstance(DPRemoteDataSource.getInstance(), DPLocalDataSource.getInstance(mContext)),
                this);
        refreshSwipe.setColorSchemeResources(
                R.color.swipe_refresh_first, R.color.swipe_refresh_second,
                R.color.swipe_refresh_third, R.color.swipe_refresh_four
        );
        refreshSwipe.setOnRefreshListener(mPresenter);
        errorFrame.setOnFailedClickListener(mPresenter);

        TestWrapContentLinearLayoutManager testWrapContentLinearLayoutManager = new TestWrapContentLinearLayoutManager(mContext);
        testWrapContentLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        deepSpaceAdapter.setOnLoadMoreListener(mPresenter);

        recyclerView.setLayoutManager(testWrapContentLinearLayoutManager);
        recyclerView.setItemAnimator(defaultItemAnimator);
        recyclerView.setAdapter(deepSpaceAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        if (deepSpaceAdapter.getDataSize() == 0)
            mPresenter.start();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void showDP(DeepSpaceBean deepSpaceBean) {
        if (deepSpaceBean == null) {
            return;
        }
        errorFrame.setState(ErrorLayout.HIDE);
        deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_LOAD_MORE);
        deepSpaceAdapter.addItem(deepSpaceBean);
    }

    @Override
    public void showLoading() {
        if (deepSpaceAdapter.getDataSize() == 0) {
            errorFrame.setState(ErrorLayout.LOADING);
        }
    }

    @Override
    public void showLoadError(String str) {
        refreshSwipe.setEnabled(true);
        refreshSwipe.setRefreshing(false);
        mState = STATE_NONE;
        deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_HIDE);
        deepSpaceAdapter.notifyItemChanged(deepSpaceAdapter.getItemCount());
        if (deepSpaceAdapter.getDataSize() > 0) {
            ToastUtil.toast(str);
        } else {
            ToastUtil.toast(str);
            errorFrame.setState(ErrorLayout.LOAD_FAILED);
        }
        deepSpaceAdapter.notifyDataSetChanged();

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
        deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_HIDE);

    }

    @Override
    public void showNoMoreDP() {
        errorFrame.setState(ErrorLayout.HIDE);
        deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_NO_MORE);
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
    public void showReloadOnError() {
        errorFrame.setState(ErrorLayout.LOADING);
    }

    @Override
    public void showLoadMore() {
        if (mState == STATE_REFRESHING) {
            deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_REFRESHING);
            return;
        }
        deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_LOADING);
    }

    @Override
    public void showRefresh() {
        if (mState == STATE_REFRESHING)
            return;
        mState = STATE_REFRESHING;
        refreshSwipe.setRefreshing(true);
        refreshSwipe.setEnabled(false);
        deepSpaceAdapter.clear();
    }
}
