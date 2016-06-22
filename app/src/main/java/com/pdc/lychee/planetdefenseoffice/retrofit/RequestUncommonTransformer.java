package com.pdc.lychee.planetdefenseoffice.retrofit;

import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by lychee on 2016/6/22.
 */
public class RequestUncommonTransformer implements Observable.Transformer<DeepSpaceBean, DeepSpaceBean> {
    @Override
    public Observable<DeepSpaceBean> call(Observable<DeepSpaceBean> tObservable) {
        return tObservable.map(new Func1<DeepSpaceBean, DeepSpaceBean>() {
            @Override
            public DeepSpaceBean call(DeepSpaceBean deepSpaceBean) {
                if (deepSpaceBean.getCode() == 400) {
                    deepSpaceBean.setExplanation("（机密）无权访问当前日期！");
                    return deepSpaceBean;
                } else if (deepSpaceBean.getCode() == 500) {
                    deepSpaceBean.setExplanation("（错误）因为相对论");
                    return deepSpaceBean;
                }
//                deepSpaceBean.setExplanation("没啥错误，就是显示不出来");
                return deepSpaceBean;
            }
        });
//                .onErrorReturn(new Func1<Throwable, DeepSpaceBean>() {
//                    @Override
//                    public DeepSpaceBean call(Throwable throwable) {
//                        DeepSpaceBean deepSpaceBean = new DeepSpaceBean();
//                        if (throwable.getMessage().equals("400")) {
//                            deepSpaceBean.setExplanation("（机密）无权访问当前日期！");
//                            return deepSpaceBean;
//                        } else if (throwable.getMessage().equals("500")) {
//                            deepSpaceBean.setExplanation("（错误）因为相对论");
//                            return deepSpaceBean;
//                        }
//                        deepSpaceBean.setExplanation("没啥错误，就是显示不出来");
//                        return deepSpaceBean;
//                    }
//                });
    }
//    @Override
//    public Observable<DeepSpaceBean> call(Observable<DeepSpaceBean> tObservable) {
//        return tObservable.map(new Func1<DeepSpaceBean, DeepSpaceBean>() {
//            @Override
//            public DeepSpaceBean call(DeepSpaceBean s) {
//                Gson gson = new Gson();
//                DeepSpaceBean deepSpaceBean = gson.fromJson(s, DeepSpaceBean.class);
//                return deepSpaceBean;
//            }
//        })
//                .onErrorReturn(new Func1<Throwable, DeepSpaceBean>() {
//                    @Override
//                    public DeepSpaceBean call(Throwable throwable) {
//                        return null;
//                    }
//                });
//    }
//    @Override
//    public Observable<DeepSpaceBean> call(Observable<String> tObservable) {
//        return tObservable.onErrorReturn(new Func1<Throwable, String>() {
//            @Override
//            public String call(Throwable throwable) {
//                DeepSpaceBean deepSpaceBean = new DeepSpaceBean();
//                deepSpaceBean.setExplanation("（机密）无权访问当前日期！");
//                return "";
//            }
//        });
//    }
}
