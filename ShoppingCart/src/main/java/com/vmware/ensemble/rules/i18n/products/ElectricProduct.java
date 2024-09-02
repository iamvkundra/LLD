package com.vmware.ensemble.rules.i18n.products;

public class ElectricProduct extends Product {

    public ElectricProduct(String productName, int price) {
        super(productName, price);
    }

    @Override
    public long getPrice() {
        return this.originalPrice;
    }
}
