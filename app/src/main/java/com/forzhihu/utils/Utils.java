package com.forzhihu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tc on 2017/2/24.
 */

public class Utils {

    public static boolean isEmailCorrect(String email) {
        boolean isMatched = false;
        //电子邮件
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        if (email.isEmpty()) {
            isMatched = false;
        } else {
            isMatched = matcher.matches();
        }
        return isMatched;
    }

    public static boolean isPasswordCorrect(String password) {
        boolean isMatched = false;
        //密码是否以字母开头
        String check = "\\b[a-z]\\w*";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(password);
        isMatched = matcher.matches();
        return isMatched;
    }


}
