package com.resteasy.service;

import com.resteasy.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class MyService {
    Map<String, Product> store = new HashMap<String, Product>();

    public MyService() {
        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setQty(100);

        Product tv = new Product();
        laptop.setName("TV");
        laptop.setQty(50);

        store.put("Laptop", laptop);
        store.put("TV", tv);
    }


    public Product getProduct(String name) {
        return store.get(name);
    }
}