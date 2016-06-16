package com.pdc.lychee.planetdefenseoffice.base.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

/**
 * Created by lychee on 2016/5/12.
 */
public abstract class BaseFragment extends BaseRxFragment {
    public Context mContext;
    public Resources mRes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mRes = mContext.getResources();
    }
}
