package com.reeching.sanitation.app.recyclerviewadapter.interfaces;


import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;

/**
 */
public interface OnItemLongClickListener<T> {
    void onItemLongClick(ViewHolder viewHolder, T data, int position);
}
