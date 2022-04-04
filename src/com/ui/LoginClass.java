package com.ui;

import com.bean.User;
import com.service.Implement.UserServiceImplement;
import com.service.UserService;
import com.utils.LoginException;

public class LoginClass extends BaseClass{
    public void login() throws LoginException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        User user = new User(username,password);
        UserService userService = new UserServiceImplement();
        User userChecked = userService.login(user);
        if(userChecked!=null){
            currentUser = userChecked;
        }else {
            throw new LoginException(getString("login.error"));
        }
    }
}
