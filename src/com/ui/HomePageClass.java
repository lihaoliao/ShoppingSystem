package com.ui;

import com.bean.Clothes;
import com.service.ClothesService;
import com.service.Implement.ClothesServiceImplement;
import com.shop.App;
import com.utils.ConsoleTable;

import java.util.List;

public class HomePageClass extends BaseClass{
    public void show(){
        println("Welcome "+currentUser.getUsername()+"!");
        showProducts();
        boolean flag = true;
        while (flag){
            println(getString("home.function"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1"://查询全部订单
                    viewAllOrder();
                    flag = false;
                    break;
                case "2"://查找订单
                    searchOrderById();
                    flag = false;
                    break;
                case "3"://购买
                    purchase();
                    flag = false;
                    break;
                case "0"://切换用户
                    flag = false;
                    WelcomeClass w = new WelcomeClass();
                    w.start();
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }

    private void searchOrderById() {
    }

    private void purchase() {
    }


    private void viewAllOrder() {
    }

    private void showProducts(){
        ClothesService clothesService = new ClothesServiceImplement();
        List<Clothes> clothes = clothesService.list();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColum("id")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("num")
                .appendColum("price")
                .appendColum("description");

        for(Clothes c:clothes){
            t.appendRow();;
            t.appendColum(c.getId())
                    .appendColum(c.getBrand())
                    .appendColum(c.getStyle())
                    .appendColum(c.getColor())
                    .appendColum(c.getSize())
                    .appendColum(c.getNum())
                    .appendColum(c.getPrize())
                    .appendColum(c.getDescription());
        }
        System.out.println(t.toString());
    }
}
