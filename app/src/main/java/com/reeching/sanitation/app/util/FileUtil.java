package com.reeching.sanitation.app.util;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 绍轩 on 2017/12/12.
 */

public class FileUtil {
    /**
     * 自定义压缩存储地址
     *
     * @return
     */
    public static String getPath() {
        String path = Environment.getExternalStorageDirectory() + "/Luban/image/";
        File file = new File(path);
        if (file.mkdirs()) {
            return path;
        }
        return path;
    }

    public static String setTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    /**
     * 删除文件（若为目录，则递归删除子目录和文件）
     *
     * @param file
     */
    public static void delFile(File file) {

        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                int num = subFiles.length;
                // 删除子目录和文件
                for (int i = 0; i < num; i++) {
                    delFile(subFiles[i]);
                }
            }
        }
        LogUtils.i(file.getPath());
        file.delete();
    }

    /**
     * 公厕图片
     * @param filePath
     */

    public static File chageToiletFileName(String filePath){
        //前面路径必须一样才能修改成功
        String path = filePath.substring(0, filePath.lastIndexOf("/")+1)+getFileName(filePath)+"t"+filePath.substring(filePath.lastIndexOf("."), filePath.length());
        return fileCopy(filePath,path);
    }
    /**
     * 周边图片
     * @param filePath
     */

    public static File chageToiletsFileName(String filePath){
        //前面路径必须一样才能修改成功
        String path = filePath.substring(0, filePath.lastIndexOf("/")+1)+getFileName(filePath)+"s"+filePath.substring(filePath.lastIndexOf("."), filePath.length());
        return fileCopy(filePath,path);
    }
    /**
     * 垃圾楼图片
     * @param filePath
     */

    public static File chageWasteFileName(String filePath){
        //前面路径必须一样才能修改成功
        String path = filePath.substring(0, filePath.lastIndexOf("/")+1)+getFileName(filePath)+"a"+filePath.substring(filePath.lastIndexOf("."), filePath.length());
        return fileCopy(filePath,path);
    }
    /**
     * 垃圾楼周边图片
     * @param filePath
     */

    public static File chageWastesFileName(String filePath){
        //前面路径必须一样才能修改成功
        String path = filePath.substring(0, filePath.lastIndexOf("/")+1)+getFileName(filePath)+"b"+filePath.substring(filePath.lastIndexOf("."), filePath.length());
        return fileCopy(filePath,path);
    }

    /**
     * 根据路径获取文件名(不带后缀名)
     * @param pathandname//路径
     * @return
     */
    public static String getFileName(String pathandname){
        int start=pathandname.lastIndexOf("/");
        //不带后缀
        int end=pathandname.lastIndexOf(".");
        if (start!=-1 && end!=-1) {
            return pathandname.substring(start+1, end);
        }
        else {
            return null;
        }
    }
    /**
     * 根据路径获取文件名(带后缀名)
     * @param pathandname//路径
     * @return
     */
    public static String getFileNameSuffix(String pathandname){
        int start=pathandname.lastIndexOf("/");
        //带后缀
        if (start!=-1){
            return pathandname.substring(start+1);
        }
        else {
            return null;
        }
    }
    /**
     * 复制文件
     * @param oldFilePath
     * @param newFilePath
     * @return
     */
    public static File fileCopy(String oldFilePath,String newFilePath)  {
        LogUtils.i(oldFilePath+"+"+newFilePath);
        //如果原文件不存在
        if(fileExists(oldFilePath) == false){
            LogUtils.i("源文件不存在");
            return null;
        }
        File oldFile;
        File newFile = null;
        //获得原文件流
        FileInputStream inputStream = null;
        try {
            oldFile=new File(oldFilePath);
            inputStream = new FileInputStream(oldFile);

            byte[] data = new byte[1024];
            newFile=new File(newFilePath);
            //输出流
            FileOutputStream outputStream =new FileOutputStream(newFile);
            //开始处理流
            while (inputStream.read(data) != -1) {
                outputStream.write(data);
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFile;
    }
    private static boolean fileExists(String oldFilePath) {
        File file = new File(oldFilePath);
        return file.exists();

    }
}
