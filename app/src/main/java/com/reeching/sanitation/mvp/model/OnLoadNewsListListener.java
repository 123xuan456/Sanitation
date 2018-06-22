package com.reeching.sanitation.mvp.model;


import com.reeching.sanitation.app.bean.ToiletListBean;

import java.util.List;

/**
 * Created by 绍轩 on 2017/12/12.
 */

public interface OnLoadNewsListListener {
    void onSuccess(List<ToiletListBean.InfosBean> ins_ChanneBean);

    void onFailure(String msg, Exception e);
}
