package com.bean;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private static final long serialVersionUID = -7226149841273295332L;
    public static int countId = 1;
    private int orderId;
    private Clothes clothes;
    private int shoppingNum;
    private float sum;//购物金额

    public OrderItem(int orderId, Clothes clothes, int shoppingNum, float sum) {
        this.orderId = orderId;
        this.clothes = clothes;
        this.shoppingNum = shoppingNum;
        this.sum = sum;
    }
    public OrderItem(){

    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
