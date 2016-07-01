package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import android.support.v4.widget.SwipeRefreshLayout;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.base.BasePresenter;
import com.pdc.lychee.planetdefenseoffice.base.BaseView;
import com.pdc.lychee.planetdefenseoffice.view.EmptyLayout;

/**
 * Created by lychee on 2016/6/16.
 */
public interface DeepSpaceMainContact {

    interface View extends BaseView<Presenter> {
        void addDP(DeepSpaceBean deepSpaceBean);

        void addDP(DeepSpaceBean deepSpaceBean, int position);

        void clearRecyclerView();

        void removeDP(String date);

        void showDeletingDialog();

        void showLoading();

        void showLoadFinished(int type);

        void setFooterView(int type);

        void showLoadMore();

        void showRefresh();

        void showReloadOnError();
    }

    interface Presenter extends BasePresenter,
            SwipeRefreshLayout.OnRefreshListener, EmptyLayout.OnReloadClickListener, DeepSpaceAdapter.OnLoadMoreListener {
        void loadDP(String date);

        void deleteDP(String date);

        String getDate();

        void setDate();

    }
}
