package com.example.justina.learningapp.data.entity;

public class Photo {

    //private int resID;
    private String imgSource;
    private String imgCaption;

    /*
    public Photo (int resourceID, String captionText){
        resID = resourceID;
        imgCaption = captionText;
    }

    public int getResourceID() {
        return resID;
    }
    */

    public Photo (String imageLink, String captionText){
        imgSource = imageLink;
        imgCaption = captionText;
    }

    public String getImgSource() {
        return imgSource;
    }

    public String getCaptionText() {
        return imgCaption;
    }

    /*
    public void setResourceID(int resourceID) {
        this.resID = resourceID;
    }
    */
    public void setImgSource(String imageLink) {
        this.imgSource = imageLink;
    }

    public void setCaptionText(String captionText) {
        this.imgCaption = captionText;
    }
}