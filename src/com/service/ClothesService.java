package com.service;

import com.bean.Clothes;

import java.util.List;

public interface ClothesService {
    List<Clothes> list();
    Clothes findById(String id);
    void update();
}
