package com.vmware.ensemble.rules.i18n.model;

import java.util.UUID;

public class Item {

    private String itemId;
    private Product product;
    private int quantity;

    public Item(Product product, int quantity)  {
        this.product = product;
        this.itemId = UUID.randomUUID().toString();
        this.quantity = quantity;
    }

    public String getItemId() {
        return this.itemId;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
