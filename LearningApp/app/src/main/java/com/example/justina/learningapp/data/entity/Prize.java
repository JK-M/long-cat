package com.example.justina.learningapp.data.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Prize extends RealmObject{

    @PrimaryKey
    private int prizeID;
    @Required
    private String imgSource, captionText;
    private String released;


    public String getImgSource() {
        return imgSource;
    }

    public String getCaptionText() {
        return captionText;
    }

    public String getReleased(){
        return released;
    }

    public int getPrizeID(){
        return prizeID;
    }

    public void setImgSource(String imageLink) {
        this.imgSource = imageLink;
    }

    public void setCaptionText(String captionText) {
        this.captionText = captionText;
    }

    public void setReleased(String releaseInfo){
        this.released = releaseInfo;
    }

    public void setPrizeID(int id){
        this.prizeID = id;
    }
}