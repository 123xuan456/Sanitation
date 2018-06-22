package com.reeching.sanitation.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.HomeImageBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 绍轩 on 2018/3/16.
 */

public class HomeImagerAdapter  extends BaseAdapter {
    private Context mContext;
    private List<HomeImageBean> list = new ArrayList<>();

    public HomeImagerAdapter(Activity activity) {
        this.mContext = activity;
    }

    public void setData(List<HomeImageBean> list) {
        if (null != list) {
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }
    public int getCount() {
        if (list != null && list.size() > 0)
            return list.size();
        else
            return 0;
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecyclerHolder view;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_home_layout, null);
            view= new RecyclerHolder(convertView);
            convertView.setLayoutParams(new AbsListView.LayoutParams((int) (parent
                    .getWidth() / 3), (int) (parent.getHeight() / 2)));// 动态设置item的高度
            convertView.setTag(view);
        } else {
            view = (RecyclerHolder) convertView.getTag();
            convertView.setLayoutParams(new AbsListView.LayoutParams(
                    (int) (parent.getWidth() / 3),
                    (int) (parent.getHeight() / 2)));// 动态设置item的高度
        }
        if (list != null && list.size() > 0) {
            view.tv.setText(list.get(position).getTitle());
            Glide.with(mContext).load(list.get(position).getImgUrl()).into(view.iv);

        }

        return convertView;
    }

    class RecyclerHolder  {
        ImageView iv;
        TextView tv;

        private RecyclerHolder(View itemView) {
            tv = (TextView) itemView.findViewById(R.id.tv);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

}
