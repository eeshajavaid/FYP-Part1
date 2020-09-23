package com.example.finalfyp;

public class ModelNotification {

    String mImageNames, mImages, mNotification, mTime;


    public ModelNotification(String mImageNames, String mImages, String mNotification, String mTime) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mNotification = mNotification;
        this.mTime = mTime;
    }

    public String getmImageNames() {
        return mImageNames;
    }

    public void setmImageNames(String mImageNames) {
        this.mImageNames = mImageNames;
    }

    public String getmImages() {
        return mImages;
    }

    public void setmImages(String mImages) {
        this.mImages = mImages;
    }

    public String getmNotification() {
        return mNotification;
    }

    public void setmNotification(String mNotification) {
        this.mNotification = mNotification;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }


}
