package com.utils;

public class getPathUtils {
    public static String getPath(String name){
        return Thread.currentThread().getContextClassLoader().getResource(name).getPath();
    }
}
