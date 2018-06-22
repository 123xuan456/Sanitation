package com.reeching.sanitation.app.recyclerviewadapter.interfaces;


import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;

/**
 */
public interface OnItemClickListener<T> {
    void onItemClick(ViewHolder viewHolder, T data, int position);

}
