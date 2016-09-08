package com.pdc.lychee.planetdefenseoffice.module.mars;

import com.pdc.lychee.planetdefenseoffice.base.BasePresenter;
import com.pdc.lychee.planetdefenseoffice.base.BaseView;

/**
 * Created by lychee on 2016/9/8.
 */
public class MarsMainContact {

    interface View extends BaseView<Presenter> {
        void initView();
    }

    interface Presenter extends BasePresenter {
        void doNothing();
    }
}
