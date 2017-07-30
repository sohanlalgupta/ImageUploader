package com.example.sohan.imageuploader;

import android.content.Intent;
import android.net.Uri;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sohan on 30-07-2017.
 */
public class ImageUploader implements Runnable{

    private static final String TAG = "ImageUploader";
    private Intent mData;
    public ImageUploader(Intent data){
        mData=data;
    }

    @Override
    public void run() {
        try {
            Map config = new HashMap();
            config.put("cloud_name", "dkepfkeuu");
            config.put("api_key", "552563677649679");
            config.put("api_secret", "7n8wJ42Hr_6nqZ4aOMDXjTIZ4P0");
            Cloudinary cloudinary = new Cloudinary(config);
            Uri path=mData.getData();
            cloudinary.uploader().upload(path, ObjectUtils.emptyMap());

        } catch (Exception e) {
        }
    }

}
