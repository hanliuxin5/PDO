package com.pdc.lychee.planetdefenseoffice.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by lychee on 2016/5/16.
 */
public class FixWrapContentLinearLayoutManager extends LinearLayoutManager {
    public FixWrapContentLinearLayoutManager(Context context) {
        super(context);
    }

    public FixWrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public FixWrapContentLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
            LogUtil.e("onLayoutChildren");
        }
    }
}
