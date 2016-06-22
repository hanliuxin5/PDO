package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.module.deepspace.data.DPRepository;
import com.pdc.lychee.planetdefenseoffice.retrofit.RequestUncommonTransformer;
import com.pdc.lychee.planetdefenseoffice.utils.TimeUtil;
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

    private String date = "";
    private boolean hd = false;

    public DeepSpaceMainPresenter(DPRepository dpRepository, DeepSpaceMainContact.View deepSpaceMainView) {
        mDeepSpaceMainView = deepSpaceMainView;
        mDpRepository = dpRepository;
        mDeepSpaceMainView.setPresenter(this);
    }

    @Override
    public void start() {
//        Date date1 = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        date = dateFormat.format(date1);
        date = "1995-09-25";
        hd = false;
        loadDP(date, hd);
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
                .compose(new RequestUncommonTransformer())
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
    public void onLoadFailedClick() {
        mDeepSpaceMainView.showReloadOnError();
        start();

    }

    @Override
    public void onLoadMore() {
        mDeepSpaceMainView.showLoadMore();
        date = TimeUtil.theDayBefore(date);
        loadDP(date, hd);
    }

    @Override
    public void onRefresh() {
        mDeepSpaceMainView.showRefresh();
        start();
    }
}
