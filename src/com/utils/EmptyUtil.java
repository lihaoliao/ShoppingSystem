package com.utils;

public class EmptyUtil {
    public static boolean isEmpty(String s){
        if(s==null || s.equals("")){
            return true;
        }
        return false;
    }
}
