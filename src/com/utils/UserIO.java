package com.utils;

import com.bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserIO {
    private static List<User> Users = new ArrayList<>();
    private static final String USER_FILE = "ShoppingSystem/userinfo";

    //写入用户列表
    public boolean writeUsers() {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(USER_FILE));
            outputStream.writeObject(Users);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean readUsers(){
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(USER_FILE));
            Users = (List<User>) inputStream.readObject();
            //System.out.println("1");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }  finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public void addUser(User user){
        user.setId(Users.size()+1);
        Users.add(user);
    }

    public User findUsernameAndPassword(User user){
        for(User u:Users){
            if(u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword())){
                return u;
            }
        }
        return null;
    }
}
