package com.vmware.ensemble.rules.i18n.products;

import java.util.UUID;

public abstract class Product {

    String productId ;
    String productName;
    long originalPrice;

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Product(String productName, int price) {
        this.productId = UUID.randomUUID().toString();
        this.originalPrice = price;
        this.productName = productName;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public abstract long getPrice();
}
