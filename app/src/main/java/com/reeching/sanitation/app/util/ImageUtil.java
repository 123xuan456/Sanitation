package com.reeching.sanitation.app.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.pictureview.ImagePagerActivity;
import com.example.pictureview.PictureConfig;
import com.reeching.sanitation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 绍轩 on 2018/6/8.
 * 查看图片详情
 */

public class ImageUtil {
    public static void showImage(Context context, List<String> lists,int position){
        if (lists.size()>0){
            PictureConfig config = new PictureConfig.Builder()
                    .setListData((ArrayList<String>)lists)//图片数据List<String> list
                    .setPosition(position)//图片下标（从第position张图片开始浏览）
                    .setDownloadPath("pictureviewer")//图片下载文件夹地址
                    .needDownload(true)//是否支持图片下载
                    .setPlacrHolder(R.mipmap.a)//点位图
                    .build();
            ImagePagerActivity.startActivity(context, config);
        }else {
            LogUtils.i("图片为空");
        }
    }
    public static void showImage(Context context, String list){
        ArrayList<String> lists=new ArrayList<>();
        lists.add(list);
        if (lists.size()>0){
            PictureConfig config = new PictureConfig.Builder()
                    .setListData(lists)//图片数据List<String> list
                    .setPosition(0)//图片下标（从第position张图片开始浏览）
                    .setDownloadPath("pictureviewer")//图片下载文件夹地址
                    .needDownload(true)//是否支持图片下载
                    .setPlacrHolder(R.mipmap.a)
                    .build();
            ImagePagerActivity.startActivity(context, config);
        }else {
            LogUtils.i("图片为空");
        }
    }


    public static void displayImage(Context context, String path, ImageView imageView) {
        RequestOptions options = (new RequestOptions()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder);
        Glide.with(context).asBitmap().load(path).apply(options).thumbnail(0.1F).into(imageView);
    }



}
