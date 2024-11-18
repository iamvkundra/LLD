package com.vmware.ensemble.rules.i18n.services;

import com.vmware.ensemble.rules.i18n.enums.Coin;
import com.vmware.ensemble.rules.i18n.model.Item;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    public static VendingMachine vendingMachine;
    public VendingState vendingState;
    private List<Coin> coins;
    private List<Item> items;

    private VendingMachine() {
        this.coins = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public static VendingMachine getVendingMachine() {
        if (vendingMachine == null) {
            synchronized (VendingMachine.class) {
                if (vendingMachine == null) {
                    vendingMachine = new VendingMachine();
                }
            }
        }
        return vendingMachine;
    }

    public VendingState getVendingState() {
        return this.vendingState;
    }

    public void setVendingState(VendingState vendingState) {
        this.vendingState = vendingState;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Coin> getCoins() {
        return this.coins;
    }

    public void removeCoins() {
        this.coins = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return this.items;
    }

    public Item getItem(String itemCode) {
        Item item  = null;
        for (Item i : items) {
            if(i.getItemId().equals(itemCode)) {
                item = i;
                break;
            }
        }
        return item;
    }
}
