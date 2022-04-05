package com.utils;

import com.bean.Order;
import com.bean.User;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderIO {
    private static List<Order> orders = new ArrayList<>();
    private static final String ORDER_FILE = "ShoppingSystem/ordersInfo";

    public void addOrder(Order order){
        order.setOrderId(orders.size()+1);
        orders.add(order);
    }

    public  List<Order> list(){
        return orders;
    }

    public Order searchOrderById(int id){
        Order order = null;
        for(Order o:orders){
            if(o.getOrderId()==id){
                order = o;
                break;
            }
        }
        return order;
    }

    public boolean writeOrders(){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
            outputStream.writeObject(orders);
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
    public boolean readOrders(){
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(ORDER_FILE));
            orders = (List<Order>) inputStream.readObject();
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
}
