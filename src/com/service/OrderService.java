package com.service;

import com.bean.Order;

import java.util.List;

public interface OrderService {
    void purchase(Order o);
    List<Order> list();
    Order searchById(int id);

}
