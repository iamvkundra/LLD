package com.vmware.ensemble.rules.i18n.products;

public class FurnitureProduct extends Product{

    public FurnitureProduct(String productName, int price) {
        super(productName, price);
    }

    @Override
    public long getPrice() {
        return this.originalPrice;
    }
}
