package com.example.justina.learningapp.data.entity;

public class Photo {

    private int resID;
    private String imgCaption;

    public Photo (int resourceID, String captionText){
        resID = resourceID;
        imgCaption = captionText;
    }

    public int getResourceID() {
        return resID;
    }

    public String getCaptionText() {
        return imgCaption;
    }

    public void setResourceID(int resourceID) {
        this.resID = resourceID;
    }

    public void setCaptionText(String captionText) {
        this.imgCaption = captionText;
    }
}