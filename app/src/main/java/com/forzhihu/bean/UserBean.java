package com.forzhihu.bean;

/**
 * Created by tc on 2017/2/22.
 */

public class UserBean {
    private String userName;
    private String email;
    private String password;
    private int img;

    public UserBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserBean(String email, String password, int img) {
        this.email = email;
        this.password = password;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
