package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import android.support.v4.widget.SwipeRefreshLayout;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.base.BasePresenter;
import com.pdc.lychee.planetdefenseoffice.base.BaseView;
import com.pdc.lychee.planetdefenseoffice.view.ErrorLayout;

/**
 * Created by lychee on 2016/6/16.
 */
public interface DeepSpaceMainContact {

    interface View extends BaseView<Presenter> {
        void addDP(DeepSpaceBean deepSpaceBean);

        void addDP(DeepSpaceBean deepSpaceBean, int position);

        void showLoading();

        void showLoadError(String str);

        void showLoadFinish();

        void showNoDp();

        void showDPDetails();

        void showNoMoreDP();

        void showLoadMore();

        void showRefresh();

        void showReloadOnError();

        void showDeletingDialog();

        void clearRecyclerView();

        void removeDP(String date);

    }

    interface Presenter extends BasePresenter,
            SwipeRefreshLayout.OnRefreshListener, ErrorLayout.OnFailedClickListener, DeepSpaceAdapter.OnLoadMoreListener {
        void loadDP(String date);

        void loadSavedDP();

        void deleteDP(String date);

        String getDate();

    }
}
