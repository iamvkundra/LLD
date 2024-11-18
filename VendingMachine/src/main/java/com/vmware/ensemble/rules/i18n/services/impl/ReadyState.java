package com.vmware.ensemble.rules.i18n.services.impl;

import com.vmware.ensemble.rules.i18n.enums.Coin;
import com.vmware.ensemble.rules.i18n.model.Item;
import com.vmware.ensemble.rules.i18n.model.Product;
import com.vmware.ensemble.rules.i18n.services.VendingMachine;
import com.vmware.ensemble.rules.i18n.services.VendingState;

import java.util.List;

public class ReadyState implements VendingState {

    public ReadyState() {
        System.out.println("Vending Machine is in Ready State");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        vendingMachine.setVendingState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Coin> coins) {
        throw new RuntimeException("Cannot click on Insert Coin Button");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, String itemCode) {
        throw new RuntimeException("Cannot click on Insert Coin Button");
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, Item item) {
        throw new RuntimeException("Cannot click on Insert Coin Button");
    }

    @Override
    public List<Coin> exit(VendingMachine vendingMachine) {
        vendingMachine.removeCoins();
        vendingMachine.setVendingState(new ReadyState());
        return null;
    }

    @Override
    public List<Coin> getChange(VendingMachine vendingMachine, int returnChangeMoney) {
        throw new RuntimeException("Cannot click on Insert Coin Button");
    }
}
