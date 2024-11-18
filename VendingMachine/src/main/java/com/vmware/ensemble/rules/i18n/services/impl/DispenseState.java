package com.vmware.ensemble.rules.i18n.services.impl;

import com.vmware.ensemble.rules.i18n.enums.Coin;
import com.vmware.ensemble.rules.i18n.model.Item;
import com.vmware.ensemble.rules.i18n.model.Product;
import com.vmware.ensemble.rules.i18n.services.VendingMachine;
import com.vmware.ensemble.rules.i18n.services.VendingState;

import java.util.List;

public class DispenseState implements VendingState {
    public DispenseState(VendingMachine vendingMachine, Item item) {
        dispenseProduct(vendingMachine, item);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Coin> coins) {

    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, String itemCode) {

    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, Item item) {
        item.setQuantity(item.getQuantity()-1);
        vendingMachine.setVendingState(new ReadyState());
        return item.getProduct();

    }

    @Override
    public List<Coin> exit(VendingMachine vendingMachine) {
        return List.of();
    }

    @Override
    public List<Coin> getChange(VendingMachine vendingMachine, int returnChangeMoney) {
        return List.of();
    }
}
