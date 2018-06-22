package com.reeching.sanitation.app.util.pic;

import android.app.Activity;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.reeching.sanitation.app.adapter.GridImagesAdapter;

import static com.reeching.sanitation.app.contant.Contants.INS_WCAdd_MUCHPIC;
import static com.reeching.sanitation.app.util.FileUtil.getPath;

/**
 * Created by 绍轩 on 2017/12/15.
 */

public class AddMuchPic implements GridImagesAdapter.onAddPicClickListener{
    private Activity activity;
    //根据type判断选择多张还是单张图片
    private  int type;
    public AddMuchPic(Activity activity){
        this.activity=activity;
    }
    @Override
    public void onAddPicClick() {
        PictureSelector.create(activity)
                .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .imageSpanCount(4)// 每行显示个数
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选PictureConfig.SINGLE
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .compress(true)// 是否压缩
                .compressSavePath(getPath())//压缩图片保存地址
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
        //设置type，在AddACtivity 的onActivityResult 会用到
        setType(INS_WCAdd_MUCHPIC);
    }
    public int getType(){
        return  type;
    }
    public void setType( int type) {
        this.type=type;
    }

}
