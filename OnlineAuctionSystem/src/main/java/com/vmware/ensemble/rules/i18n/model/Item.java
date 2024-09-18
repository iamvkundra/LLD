package com.vmware.ensemble.rules.i18n.model;

import com.vmware.ensemble.rules.i18n.model.Account.User;

public class Item {

    private String itemId;
    private String itemName;
    private String description;
    private long basePrice;
    private User seller;

    public Item(String itemId, String itemName, String description, long basePrice, User seller) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.basePrice = basePrice;
        this.seller = seller;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public User getSeller() {
        return seller;
    }
}
