package com.reeching.sanitation.app.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by de on 2016/12/19.
 */
public class GlideImageLoader extends ImageLoader {
    //轮播图显示
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        RequestOptions options = (new RequestOptions()).diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).asBitmap().load(path).apply(options).thumbnail(0.1F).into(imageView);

//        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(path.toString(), imageView);
    }



}
