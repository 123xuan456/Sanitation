package com.reeching.sanitation.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 绍轩 on 2018/3/3.
 */

public class PaymentdetailsGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> list = new ArrayList<>();

    public PaymentdetailsGridAdapter(Activity activity) {
        this.mContext = activity;
    }

    public void setData(List<String> list) {
        if (null != list) {
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }
    public int getCount() {
        if (list != null && list.size() > 0){
            return list.size();
        }
        else{
            return 0;
        }
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecyclerHolder view;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_payment_griddetails, null);
            view= new RecyclerHolder(convertView);
            convertView.setTag(view);
        } else {
            view = (RecyclerHolder) convertView.getTag();
        }
            String url = list.get(position);
//            ImageLoader.getInstance().displayImage("http://192.168.3.110:8088/envir/userfiles/1/images/questionPhoto/2017/12/fdafdsa.png",
//                    view.iv);
        LogUtils.i(list.size());
            ImageLoader.getInstance().displayImage(url,
                    view.iv);

        return convertView;
    }
    class RecyclerHolder  {
        ImageView iv;
        TextView tv;

        private RecyclerHolder(View itemView) {
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}