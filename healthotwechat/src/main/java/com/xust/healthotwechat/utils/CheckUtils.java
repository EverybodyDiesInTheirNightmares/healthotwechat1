package com.xust.healthotwechat.utils;

import java.util.regex.Pattern;

public class CheckUtils {

    //校验输入账号是否为邮箱
    public static final String IS_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static Boolean is_Email(String email){
        return Pattern.matches(IS_EMAIL, email);
    }

    public static Boolean is_Sno(String sno){
        return sno.isEmpty() && sno.length() == 8;
    }

}
