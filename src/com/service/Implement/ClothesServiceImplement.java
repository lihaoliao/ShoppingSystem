package com.service.Implement;

import com.bean.Clothes;
import com.service.ClothesService;
import com.utils.ProductsXmlUtils;

import java.util.List;

public class ClothesServiceImplement implements ClothesService {

    @Override
    public List<Clothes> list() {
        return ProductsXmlUtils.getProducts();
    }
}
