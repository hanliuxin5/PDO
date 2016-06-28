package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.pdc.lychee.planetdefenseoffice.R;
import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.base.fragment.BaseFragment;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPRepository;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.local.DPLocalDataSource;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.remote.DPRemoteDataSource;
import com.pdc.lychee.planetdefenseoffice.utils.LogUtil;
import com.pdc.lychee.planetdefenseoffice.utils.TestWrapContentLinearLayoutManager;
import com.pdc.lychee.planetdefenseoffice.utils.TimeUtil;
import com.pdc.lychee.planetdefenseoffice.utils.ToastUtil;
import com.pdc.lychee.planetdefenseoffice.view.ErrorLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceMainFragment extends BaseFragment implements DeepSpaceMainContact.View {


    //    @Bind(R.id.toolbar)
    Toolbar toolbar;
    //    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.refresh_swipe)
    SwipeRefreshLayout refreshSwipe;
    @Bind(R.id.error_frame)
    ErrorLayout errorFrame;
    @Bind(R.id.content_fl)
    FrameLayout contentFl;

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
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deepspace, container, false);
        ButterKnife.bind(this, view);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) mContext;
        activity.setSupportActionBar(toolbar);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.tasks_fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_delete:
                showDeletingDialog();
                break;
            case R.id.menu_refresh:
                LogUtil.d("重新加载：" + TimeUtil.theDayBefore(mPresenter.getDate()));
                mPresenter.loadDP(TimeUtil.theDayBefore(mPresenter.getDate()));
                break;
        }
        return true;
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
    public void addDP(DeepSpaceBean deepSpaceBean) {
        if (deepSpaceBean == null) {
            return;
        }
        errorFrame.setState(ErrorLayout.HIDE);
        deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_LOAD_MORE);
        deepSpaceAdapter.addItem(deepSpaceBean);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addDP(DeepSpaceBean deepSpaceBean, int position) {
        if (deepSpaceBean == null) {
            return;
        }
        errorFrame.setState(ErrorLayout.HIDE);
        deepSpaceAdapter.setState(DeepSpaceAdapter.STATE_LOAD_MORE);
        deepSpaceAdapter.addItem(deepSpaceBean, position);
    }

    @Override
    public void showLoading() {
        if (mState == STATE_REFRESHING)
            return;
        mState = STATE_REFRESHING;
        refreshSwipe.setEnabled(false);
        if (deepSpaceAdapter.getDataSize() == 0) {
            errorFrame.setState(ErrorLayout.LOADING);
        }
    }

    @Override
    public void showLoadError(String str) {
        refreshSwipe.setRefreshing(false);
        refreshSwipe.setEnabled(true);
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
        mState = STATE_NONE;
        errorFrame.setState(ErrorLayout.HIDE);
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
    public void showDeletingDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
        builder1.setMessage("请填写如要删除的日期,例如 \n2016-06-27");

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        final EditText et = new EditText(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        et.setLayoutParams(lp);
        builder1.setView(et);
        et.setText(dateFormat.format(date));

        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPresenter.deleteDP(et.getText().toString().trim());
            }
        });
        builder1.setNegativeButton("取消", null);
        builder1.show();
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
    }

    @Override
    public void clearRecyclerView() {
        deepSpaceAdapter.clear();
    }

    @Override
    public void removeDP(String date) {
        DeepSpaceBean deepSpaceBean = null;
        boolean isExist = false;
        for (int i = 0; i < deepSpaceAdapter.getItems().size(); i++) {
            deepSpaceBean = (DeepSpaceBean) deepSpaceAdapter.getItem(i);
            if (deepSpaceBean.getDate().equals(date)) {
                isExist = true;
                deepSpaceAdapter.removeItem(i);
                LogUtil.i("删除日期：" + date + ",position：" + i);
                break;
            }
        }
        if (!isExist)
            LogUtil.i("当前日期不在列表中");
    }

}
