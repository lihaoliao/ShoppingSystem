package com.ui;

import com.bean.User;

import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class BaseClass {
    protected static Scanner input = new Scanner(System.in);
    protected static User currentUser;
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("com.recourse.recourse");


    public static String getString(String key){
        return resourceBundle.getString(key);
    }

    public static void println(String key){
        System.out.println(key);
    }

    public static void print(String key){
        System.out.print(key);
    }
}
