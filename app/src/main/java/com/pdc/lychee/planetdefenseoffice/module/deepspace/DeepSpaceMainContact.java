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
        void showDP(DeepSpaceBean deepSpaceBean);

        void showLoading();

        void showLoadError();

        void showLoadFinish();

        void showNoDp();

        void showDPDetails();

        void showNoMoreDP();

        void showLoadMore();

        void showRefresh();

        void showReloadOnError();


    }

    interface Presenter extends BasePresenter,
            SwipeRefreshLayout.OnRefreshListener, ErrorLayout.OnFailedClickListener, DeepSpaceAdapter.OnLoadMoreListener {
        void loadDP(String date, boolean hd);
    }
}
