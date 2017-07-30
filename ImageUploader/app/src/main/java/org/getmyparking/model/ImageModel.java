package org.getmyparking.model;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by sohan on 30-07-2017.
 */

public class ImageModel implements Serializable {

    String path;
    Bitmap bmp;
    public ImageModel(){

    }

    public void setPath(String path){
        this.path=path;
    }

    public void setBitmap(Bitmap bmp){
        this.bmp=bmp;
    }

    public Bitmap getBitmap(){
        return bmp;
    }

    public String getImagePath(){
        return path;
    }
}
