package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import com.pdc.lychee.planetdefenseoffice.base.BasePresenter;
import com.pdc.lychee.planetdefenseoffice.base.BaseView;

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



    }

    interface Presenter extends BasePresenter {
        void loadDP(String date, boolean hd);
    }
}
