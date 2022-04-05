package com.ui;

import com.bean.Clothes;
import com.bean.Order;
import com.bean.OrderItem;
import com.service.ClothesService;
import com.service.Implement.ClothesServiceImplement;
import com.service.Implement.OrderServiceImplement;
import com.service.OrderService;
import com.utils.ClothesIO;
import com.utils.ConsoleTable;
import com.utils.DateUtils;
import com.utils.OrderIO;

import java.util.List;

public class HomePageClass extends BaseClass{
    private OrderService orderService = new OrderServiceImplement();
    private ClothesService clothesService = new ClothesServiceImplement();
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
        //生成订单
        Order order = new Order();
        boolean flag = true;
        float total = 0.0f;
        while (flag){
            println(getString("input.productId"));
            String id = input.nextLine();
            Clothes result = clothesService.findById(id);
            if(result==null){
                println(getString("input.error"));
                continue;
            }
            println(getString("input.productNum"));
            int num = Integer.parseInt(input.nextLine());
            if(result.getNum()<num){
                println(getString("clothes.num"));
                continue;
            }
            //一条订单
            result.setNum(result.getNum()-num);
            OrderItem orderItem = new OrderItem();
            orderItem.setShoppingNum(num);
            orderItem.setClothes(result);
            orderItem.setSum(result.getPrize()*num);
            total += result.getPrize()*num;
            orderItem.setOrderId(OrderItem.countId++);
            order.getOrderItemList().add(orderItem);

            println(getString("continue"));
            println(getString("info.select"));
            String s = input.nextLine();
            switch (s){
                case "1":
                    flag = true;
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        order.setCreateDate(DateUtils.current());
        order.setUserId(currentUser.getId());
        order.setSum(total);
        order.setOrderId(orderService.list().size()+1);
        orderService.purchase(order);
        clothesService.update();
        show();
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
