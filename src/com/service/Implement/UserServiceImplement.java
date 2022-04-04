package com.service.Implement;

import com.bean.User;
import com.service.UserService;
import com.utils.EmptyUtil;
import com.utils.LoginException;
import com.utils.UserIO;

import java.util.ResourceBundle;

public class UserServiceImplement implements UserService {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("com.recourse.recourse");
    @Override
    public User register(User user) {
        UserIO userIO = new UserIO();
        userIO.addUser(user);
        userIO.writeUsers();
        return null;
    }

    @Override
    public User login(User user) throws LoginException {
        if(EmptyUtil.isEmpty(user.getUsername())){
            throw new LoginException(resourceBundle.getString("username.notnull"));
        }
        if(EmptyUtil.isEmpty(user.getPassword())){
            throw new LoginException(resourceBundle.getString("password.notnull"));
        }
        UserIO userIO = new UserIO();
        return userIO.findUsernameAndPassword(user);
    }
}
