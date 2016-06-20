package com.pdc.lychee.planetdefenseoffice.module;

import com.pdc.lychee.planetdefenseoffice.base.BasePresenter;
import com.pdc.lychee.planetdefenseoffice.base.BaseView;

/**
 * Created by lychee on 2016/6/16.
 */
public interface MainContract {
     interface View extends BaseView<Presenter> {
        void showOffice(int index);

        void showNetWorkingError();

        void showPopUpMenu();

        void openDrawer();

        void closeDrawer();

    }

     interface Presenter extends BasePresenter {
        void firstPresenter();
    }
}
