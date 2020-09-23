package com.example.finalfyp;

public class ModelFriendRequest {
    String mImageNames, mImages, mButtons, mButtons1;

    public ModelFriendRequest(String mImageNames, String mImages, String mButtons, String mButtons1) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mButtons = mButtons;
        this.mButtons1 = mButtons1;
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

    public String getmButtons() {
        return mButtons;
    }

    public void setmButtons(String mButtons) {
        this.mButtons = mButtons;
    }

    public String getmButtons1() {
        return mButtons1;
    }

    public void setmButtons1(String mButtons1) {
        this.mButtons1 = mButtons1;
    }
}
