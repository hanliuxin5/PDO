package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pdc.lychee.planetdefenseoffice.R;
import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.base.adapter.BaseRecyclerViewAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lychee on 2016/6/21.
 */
public class DeepSpaceAdapter extends BaseRecyclerViewAdapter {
    public DeepSpaceAdapter(Context context, List items, int mode) {
        super(context, items, mode);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new APODViewHolder(mInflater.inflate(R.layout.item_apod, parent, false));
    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, int position) {
        APODViewHolder vh = (APODViewHolder) holder;
        DeepSpaceBean deepSpaceBean = (DeepSpaceBean) items.get(position);
        vh.textView3.setText(deepSpaceBean.getDate() + "\n" + deepSpaceBean.getUrl());
    }

    static class APODViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.textView3)
        TextView textView3;

        APODViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
