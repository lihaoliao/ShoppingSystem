package com.service.Implement;

import com.bean.Clothes;
import com.service.ClothesService;
import com.utils.ClothesIO;
import com.utils.ProductsXmlUtils;

import java.util.List;

public class ClothesServiceImplement implements ClothesService {
    ClothesIO clothesIO = new ClothesIO();
    @Override
    public List<Clothes> list() {
        return clothesIO.list();
    }
    @Override
    public Clothes findById(String id) {
        return clothesIO.findClothesByid(id);
    }

    @Override
    public void update() {
        clothesIO.update();
    }

}
