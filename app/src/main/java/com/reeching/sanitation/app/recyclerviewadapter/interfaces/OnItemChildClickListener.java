package com.reeching.sanitation.app.recyclerviewadapter.interfaces;


import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;

/**
 */
public interface OnItemChildClickListener<T> {
    void onItemChildClick(ViewHolder viewHolder, T data, int position);
}
