package com.service.Implement;

import com.bean.Order;
import com.service.OrderService;
import com.utils.OrderIO;

import java.util.List;

public class OrderServiceImplement implements OrderService {

    @Override
    public void purchase(Order o) {
        OrderIO orderIO = new OrderIO();
        orderIO.addOrder(o);
        orderIO.writeOrders();
    }

    @Override
    public List<Order> list() {
        return new OrderIO().list();
    }

    @Override
    public Order searchById(int id) {
        return new OrderIO().searchOrderById(id);
    }
}
