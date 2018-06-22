package com.reeching.sanitation.app.recyclerviewadapter.interfaces;


import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;

/**
 * Time: 2016/8/29 10:48
 */
public interface OnSwipeMenuClickListener<T> {
    void onSwipMenuClick(ViewHolder viewHolder, T data, int position);
}
