package com.pdc.lychee.planetdefenseoffice.module.deepspace;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdc.lychee.planetdefenseoffice.R;
import com.pdc.lychee.planetdefenseoffice.a_javabean.DeepSpaceBean;
import com.pdc.lychee.planetdefenseoffice.base.adapter.BaseRecyclerViewAdapter;
import com.pdc.lychee.planetdefenseoffice.utils.LogUtil;
import com.squareup.picasso.Picasso;

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
        return new APODViewHolder(mInflater.inflate(R.layout.item_apod_image, parent, false));
    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, int position) {
        APODViewHolder vh = (APODViewHolder) holder;
        DeepSpaceBean deepSpaceBean = (DeepSpaceBean) items.get(position);
        //照片
        if (deepSpaceBean.getMediaType() != null && deepSpaceBean.getMediaType().equals("image")) {
            vh.apodIvImg.setVisibility(View.VISIBLE);
            Picasso p = Picasso.with(mContext);
//            p.setIndicatorsEnabled(true);
            p.load(deepSpaceBean.getUrl())
                    .into(vh.apodIvImg);
            LogUtil.d("正在加载图片：" + deepSpaceBean.getUrl());
        } else {
            vh.apodIvImg.setVisibility(View.INVISIBLE);
            LogUtil.d("不是照片：" + deepSpaceBean.getUrl());

        }
        //标题
        vh.apodTvTitle.setText(deepSpaceBean.getTitle());
        //日期
        vh.apodTvDate.setText(deepSpaceBean.getDate());
        //解释
        vh.apodTvExplanation.setText(deepSpaceBean.getExplanation());
    }

    static class APODViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.apod_iv_organization_logo)
        ImageView apodIvOrganizationLogo;
        @Bind(R.id.apod_tv_organization_name)
        TextView apodTvOrganizationName;
        @Bind(R.id.apod_iv_more)
        ImageView apodIvMore;
        @Bind(R.id.apod_iv_img)
        ImageView apodIvImg;
        @Bind(R.id.apod_tv_title)
        TextView apodTvTitle;
        @Bind(R.id.apod_tv_date)
        TextView apodTvDate;
        @Bind(R.id.apod_tv_explanation)
        TextView apodTvExplanation;

        APODViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
