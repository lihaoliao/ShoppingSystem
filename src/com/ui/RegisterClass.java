package com.ui;

import com.bean.User;
import com.service.Implement.UserServiceImplement;
import com.service.UserService;
import com.utils.UserIO;

public class RegisterClass extends BaseClass{
    public void register(){
        boolean userNameCorrect = false;
        boolean passwordCorrect = false;
        String regex = "^[a-z0-9A-Z]+$";
        while (!userNameCorrect && !passwordCorrect) {
            println(getString("input.username"));
            String username = input.nextLine();
            if(username.matches(regex)){
                userNameCorrect = true;
            }else {
                println(getString("username.format"));
                continue;
            }
            println(getString("input.password"));
            String password = input.nextLine();
            if(password.length()>8){
                passwordCorrect = true;
            }
            else {
                userNameCorrect = false;
                println(getString("password.format"));
                continue;
            }
            User user = new User(username,password);
            UserService userService = new UserServiceImplement();
            userService.register(user);
        }


    }
}
