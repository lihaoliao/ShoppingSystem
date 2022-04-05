package com.ui;

import com.utils.LoginException;
import com.utils.UserIO;

public class WelcomeClass extends BaseClass{
    public void start(){
        boolean flag = true;
        println(getString("info.welcome"));
        //初始化Users列表，否则验证时Users为new出来的空List
        UserIO userIO = new UserIO();
        userIO.readUsers();
        while (flag) {
            println(getString("info.login.reg"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1":
                    try {
                        new LoginClass().login();
                        println(getString("login.success"));
                        flag = false;
                    }catch (LoginException e){
                        println(getString("login.error"));
                    }
                    break;
                case "2":
                    try {
                        new RegisterClass().register();
                        println(getString("reg.success"));
                        flag = false;
                    }catch (Exception e){
                        println(getString("reg.error"));
                    }
                    break;
                case "3":
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    println(getString("input.error"));
                    break;

            }
        }
        HomePageClass homePageClass = new HomePageClass();
        homePageClass.show();
    }
}
