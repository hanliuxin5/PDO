package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPRepository;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceMainPrsenter implements DeepSpaceMainContact.Presenter {
    private final DeepSpaceMainContact.View mDeepSpaceMainView;
    private final DPRepository mDpRepository;

    public DeepSpaceMainPrsenter(DPRepository dpRepository, DeepSpaceMainContact.View deepSpaceMainView) {
        mDeepSpaceMainView = deepSpaceMainView;
        mDpRepository = dpRepository;
        mDeepSpaceMainView.setPresenter(this);
    }

    @Override
    public void loadDP() {

    }

    @Override
    public void start() {
        loadDP();
    }
}
