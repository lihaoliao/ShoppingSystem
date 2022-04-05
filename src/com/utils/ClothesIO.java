package com.utils;

import com.bean.Clothes;

import java.util.ArrayList;
import java.util.List;

public class ClothesIO {
    private static List<Clothes> list = new ArrayList<>();
    public Clothes findClothesByid(String id){
        for(Clothes c:list){
            if(id.equals(c.getId())){
                return c;
            }
        }
        return null;
    }

    public List<Clothes> list(){
        if(list.size()==0){
            list = ProductsXmlUtils.getProducts();
        }
            return list;
    }

    public void update(){
        ProductsXmlUtils.writeProductsXml(list);
    }
}
