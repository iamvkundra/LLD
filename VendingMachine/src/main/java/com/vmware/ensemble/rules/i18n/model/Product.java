package com.vmware.ensemble.rules.i18n.model;

import java.util.UUID;

public class Product {

    private String productId;
    private String productName;
    private int price;

    public Product(String name, int price) {
        this.productName = name;
        this.price = price;
        this.productId = UUID.randomUUID().toString();
    }

    public String getProductId(){
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getPrice() {
        return this.price;
    }
}
