package com.utils;

import com.bean.Clothes;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsXmlUtils {
    public static List<Clothes> getProducts(){
        List<Clothes> products = new ArrayList<>();
        XStream xStream = new XStream(new Xpp3Driver());
        //类名节点重命名
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        //将“id"作为Clothes属性输出在父节点
        xStream.useAttributeFor(Clothes.class,"id");
        BufferedInputStream inputStream = null;
        try{
            inputStream = new BufferedInputStream(new FileInputStream(getPathUtils.getPath("products.xml")));
            //System.out.println(getPathUtils.getPath("products.xml"));
            products = (List<Clothes>) xStream.fromXML(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return products;
    }


    public static void writeProductsXml(List<Clothes> products){
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");
        BufferedOutputStream outputStream = null;
        try{
            outputStream = new BufferedOutputStream(new FileOutputStream(getPathUtils.getPath("products.xml")));
            //System.out.println(getPathUtils.getPath("products.xml"));
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>".getBytes());
            xStream.toXML(products,outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
