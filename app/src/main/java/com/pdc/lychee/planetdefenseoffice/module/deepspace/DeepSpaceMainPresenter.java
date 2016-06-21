package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPRepository;
import com.trello.rxlifecycle.FragmentEvent;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;

/**
 * Created by lychee on 2016/6/16.
 */
public class DeepSpaceMainPresenter implements DeepSpaceMainContact.Presenter {
    private final DeepSpaceMainContact.View mDeepSpaceMainView;
    private final DPRepository mDpRepository;

    public DeepSpaceMainPresenter(DPRepository dpRepository, DeepSpaceMainContact.View deepSpaceMainView) {
        mDeepSpaceMainView = deepSpaceMainView;
        mDpRepository = dpRepository;
        mDeepSpaceMainView.setPresenter(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void loadDP(String date, boolean hd) {
        mDeepSpaceMainView.showLoading();
        mDpRepository.getDP(date, hd)
                .compose(((DeepSpaceMainFragment) mDeepSpaceMainView).bindUntilEvent(FragmentEvent.DESTROY_VIEW))
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mDeepSpaceMainView.showLoading();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DeepSpaceBean>() {
                    @Override
                    public void onCompleted() {
                        mDeepSpaceMainView.showLoadFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDeepSpaceMainView.showLoadError();
                    }

                    @Override
                    public void onNext(DeepSpaceBean deepSpaceBean) {
                        mDeepSpaceMainView.showDP(deepSpaceBean);
                    }
                });
    }

    @Override
    public void start() {
        loadDP("2016-02-24", false);
    }
}
