package com.forzhihu.bean;

/**
 * Created by tc on 2017/3/1.
 */

public class UserProfileInfo {

    private int img;
    private String name;
    private String date;
    private String profile;

    public UserProfileInfo(int img, String name, String date, String profile) {
        this.img = img;
        this.name = name;
        this.date = date;
        this.profile = profile;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
