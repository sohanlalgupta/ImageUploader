package com.example.sohan.imageuploader;

import android.net.Uri;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RunnableFuture;

/**
 * Created by sohan on 30-07-2017.
 */

public class ImageDownLoader implements Runnable {

    @Override
    public void run() {
        try {
            Map config = new HashMap();
            config.put("cloud_name", "dkepfkeuu");
            config.put("api_key", "552563677649679");
            config.put("api_secret", "7n8wJ42Hr_6nqZ4aOMDXjTIZ4P0");
            Cloudinary cloudinary = new Cloudinary(config);


            cloudinary.downloadZip(config);//ObjectUtils.emptyMap());

        } catch (Exception e) {
        }
    }
}
