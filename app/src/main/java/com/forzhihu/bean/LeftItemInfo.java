package com.forzhihu.bean;

/**
 * Created by tc on 2017/2/27.
 */

public class LeftItemInfo {
    private int img;
    private String title;
    private boolean isUpdate = false;

    public LeftItemInfo() {
    }

    public LeftItemInfo(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "img=" + img +
                ", title='" + title + '\'' +
                ", isUpdate=" + isUpdate +
                '}';
    }
}
