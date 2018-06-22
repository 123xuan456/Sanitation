package com.reeching.sanitation.app.util.pic;

import android.app.Activity;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.reeching.sanitation.app.adapter.GridImageAdapter;

import static com.reeching.sanitation.app.contant.Contants.INS_WCAdd_ONEPIC;
import static com.reeching.sanitation.app.util.FileUtil.getPath;

/**
 * Created by 绍轩 addOnePic 2017/12/15.
 *
 */

public class AddOnePic implements GridImageAdapter.onAddPicClickListener {

    private  Activity activity;
    //根据type判断选择多张还是单张图片
    private  int type;
    public AddOnePic(Activity activity){
        this.activity=activity;
    }
    @Override
    public void onAddPicClick() {
                PictureSelector.create(activity)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)// 多选 or 单选PictureConfig.SINGLE
                        .imageFormat(PictureMimeType.PNG)
                        .compress(true)// 是否压缩 true or false
                        .compressSavePath(getPath())//压缩图片保存地址
                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
        setType(INS_WCAdd_ONEPIC);
    }
    public int getType(){
        return  type;
    }
    public void setType( int type) {
        this.type=type;
    }

}
