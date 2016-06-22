package com.pdc.lychee.planetdefenseoffice.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pdc.lychee.planetdefenseoffice.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lychee on 2016/6/21.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter {
    public static final int STATE_NO_MORE = 1;
    public static final int STATE_LOAD_MORE = 2;
    public static final int STATE_INVALID_NETWORK = 3;
    public static final int STATE_HIDE = 5;
    public static final int STATE_REFRESHING = 6;
    public static final int STATE_LOAD_ERROR = 7;
    public static final int STATE_LOADING = 8;

    public final int BEHAVIOR_MODE;

    public static final int ONLY_HEADER = 1;
    public static final int ONLY_FOOTER = 2;
    public static final int BOTH_HEADER_FOOTER = 3;

    protected static final int VIEW_TYPE_NORMAL = 0;
    protected static final int VIEW_TYPE_HEADER = -1;
    protected static final int VIEW_TYPE_FOOTER = -2;

    protected Context mContext;
    protected List<T> items;
    protected LayoutInflater mInflater;
    protected int mState;

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private OnLoadMoreListener onLoadingListener;
    private OnLoadingHeaderCallBack onLoadingHeaderCallBack;

    //多选模式
    private SparseBooleanArray selectedItems;

    public BaseRecyclerViewAdapter(Context context, List<T> items, int mode) {
        this.mContext = context;
        this.items = items;
        selectedItems = new SparseBooleanArray();
        mState = STATE_HIDE;
        mInflater = LayoutInflater.from(mContext);
        BEHAVIOR_MODE = mode;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && (BEHAVIOR_MODE == ONLY_HEADER || BEHAVIOR_MODE == BOTH_HEADER_FOOTER))
            return VIEW_TYPE_HEADER;
        if (position + 1 == getItemCount() && (BEHAVIOR_MODE == ONLY_FOOTER || BEHAVIOR_MODE == BOTH_HEADER_FOOTER))
            return VIEW_TYPE_FOOTER;
        else {
            return VIEW_TYPE_NORMAL;
        }
    }

    @Override
    public int getItemCount() {
        if (BEHAVIOR_MODE == ONLY_FOOTER || BEHAVIOR_MODE == ONLY_HEADER) {
            return items.size() + 1;
        } else if (BEHAVIOR_MODE == BOTH_HEADER_FOOTER) {
            return items.size() + 2;
        } else {
            return items.size();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                if (onLoadingHeaderCallBack != null)
                    return onLoadingHeaderCallBack.onCreateHeaderHolder(parent);
                else throw new IllegalArgumentException("使用头部样式列表却没有实现对应的接口！");
            case VIEW_TYPE_FOOTER:
                return new FooterViewHolder(mInflater.inflate(R.layout.base_item_footer, parent, false));
            default:
                final RecyclerView.ViewHolder holder = onCreateDefaultViewHolder(parent, viewType);
                return holder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_HEADER:
                if (onLoadingHeaderCallBack != null)
                    onLoadingHeaderCallBack.onBindHeaderHolder(holder, position);
                break;
            case VIEW_TYPE_FOOTER:
                if (mState == STATE_LOAD_MORE && onLoadingListener != null) {
                    onLoadingListener.onLoadMore();
                }
                FooterViewHolder fvh = (FooterViewHolder) holder;
                fvh.itemView.setVisibility(View.VISIBLE);
                switch (mState) {
                    case STATE_LOAD_MORE:
                    case STATE_LOADING:
                        fvh.stateText.setText(mContext.getResources().getText(R.string.loading));
                        fvh.progressbar.setVisibility(View.VISIBLE);
                        break;
                    case STATE_NO_MORE:
                        fvh.stateText.setText(mContext.getResources().getText(R.string.load_no_more));
                        fvh.progressbar.setVisibility(View.GONE);
                        break;
                    case STATE_REFRESHING:
                        fvh.stateText.setText(mContext.getResources().getText(R.string.refreshing));
                        fvh.progressbar.setVisibility(View.GONE);
                        break;
                    case STATE_HIDE:
                        fvh.itemView.setVisibility(View.GONE);
                        break;
                    case STATE_INVALID_NETWORK:
                        fvh.stateText.setText(mContext.getResources().getText(R.string.invalid_network));
                        fvh.progressbar.setVisibility(View.GONE);
                        break;
                    case STATE_LOAD_ERROR:
                        fvh.stateText.setText(mContext.getResources().getText(R.string.load_failed));
                        fvh.progressbar.setVisibility(View.GONE);
                        break;
                }
                break;

            default:
                onBindDefaultViewHolder(holder, getIndexFromReal(position));
        }
    }

    protected abstract RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type);

    protected abstract void onBindDefaultViewHolder(RecyclerView.ViewHolder holder, int position);


    /**
     * 传入的position为真实的position
     *
     * @param position
     * @return
     */
    private int getIndexFromReal(int position) {
        return BEHAVIOR_MODE == ONLY_HEADER || BEHAVIOR_MODE == BOTH_HEADER_FOOTER ? position - 1 : position;
    }

    /**
     * 传入的position为数据集中的index
     *
     * @param position
     * @return
     */
    private int getIndexFromData(int position) {
        return BEHAVIOR_MODE == ONLY_HEADER || BEHAVIOR_MODE == BOTH_HEADER_FOOTER ? position + 1 : position;
    }


    public final T getItem(int position) {
        return items.get(getIndexFromData(position));
    }

    public final void setState(int state) {
        mState = state;
    }

    public final int getState() {
        return mState;
    }

    public final int getDataSize() {
        return items.size();
    }

    public final List getItems() {
        return items;
    }

    public final void addItem(T t) {
        items.add(items.size() == 0 ? 0 : items.size(), t);
        notifyItemRangeInserted(getIndexFromData(items.size()), getIndexFromData(items.size()));
    }

    public final void addItems(List<T> objs) {
        items.addAll(objs);
        notifyItemRangeInserted(getIndexFromData(objs.size()), getIndexFromData(objs.size()));
    }

    public final void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(getIndexFromData(position));
    }

    public final void clear() {
        items.clear();
        notifyItemRangeRemoved(0, items.size());
    }

    public void removeItems(List<Integer> positions) {
        // list逆序排序
        Collections.sort(positions, new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return rhs - lhs;
            }
        });

        // 拆分排列后的list
        while (!positions.isEmpty()) {
            if (positions.size() == 1) {
                removeItem(positions.get(0));
                positions.remove(0);
            } else {
                int count = 1;
                while (positions.size() > count && positions.get(count).equals(positions.get(count - 1) - 1)) {
                    ++count;
                }

                if (count == 1) {
                    removeItem(positions.get(0));
                } else {
                    removeRange(positions.get(count - 1), count);
                }

                for (int i = 0; i < count; ++i) {
                    positions.remove(0);
                }
            }
        }
    }

    private void removeRange(int positionStart, int itemCount) {
        for (int i = 0; i < itemCount; ++i) {
            items.remove(positionStart);
        }
        notifyItemRangeRemoved(positionStart, itemCount);
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public interface OnItemLongClickListener {
        boolean onLongClick(int position);
    }


    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface OnLoadingHeaderCallBack {
        RecyclerView.ViewHolder onCreateHeaderHolder(ViewGroup parent);

        void onBindHeaderHolder(RecyclerView.ViewHolder holder, int position);
    }

    public final void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public final void setOnItemLongClickListener(OnItemLongClickListener listener) {
        onItemLongClickListener = listener;
    }

    public final void setOnLoadMoreListener(OnLoadMoreListener listener) {
        onLoadingListener = listener;
    }

    public final void setOnLoadingHeaderCallBack(OnLoadingHeaderCallBack listener) {
        onLoadingHeaderCallBack = listener;
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.progressbar)
        ProgressBar progressbar;
        @Bind(R.id.state_text)
        TextView stateText;

        FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    //选择模式-start

    /**
     * 指定对应位置的Item是否被选中
     *
     * @param position 的position
     * @return 如果是选中返回true，否则返回false
     */
    public boolean isSelected(int position) {
        return getSelectedItems().contains(position);
    }

    /**
     * 给指定postion的Item的选中状态触发器
     *
     * @param position item 的 postion
     */
    public void toggleSelection(int position) {
        if (selectedItems.get(position, false)) {
            selectedItems.delete(position);
        } else {
            selectedItems.put(position, true);
        }
        notifyItemChanged(position);
    }

    /**
     * 清空所有Item的选中状态
     */
    public void clearSelection() {
        List<Integer> selection = getSelectedItems();
        selectedItems.clear();
        for (Integer i : selection) {
            notifyItemChanged(i);
        }
    }

    /**
     * 选中Item的数量
     *
     * @return 选中Item的数量
     */
    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    /**
     * 被选中的Item的Id list
     *
     * @return 被选中的Item的Id list
     */
    public List<Integer> getSelectedItems() {
        List<Integer> items = new ArrayList<>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); ++i) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }
    //选择模式-end
}
