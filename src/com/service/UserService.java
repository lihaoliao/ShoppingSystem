package com.service;

import com.bean.User;

public interface UserService {
    User register(User user);
    User login(User user);
}
