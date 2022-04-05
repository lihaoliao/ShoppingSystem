package com.test;

import com.bean.Clothes;
import com.utils.ProductsXmlUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProductsXmlUtilsTest {
    @Test
    public void test(){
        List<Clothes> clothesList = ProductsXmlUtils.getProducts();
        System.out.println(Arrays.toString(clothesList.toArray()));
    }
}
