package com.vmware.ensemble.rules.i18n.services.impl;

import com.vmware.ensemble.rules.i18n.enums.Coin;
import com.vmware.ensemble.rules.i18n.model.Item;
import com.vmware.ensemble.rules.i18n.model.Product;
import com.vmware.ensemble.rules.i18n.services.VendingMachine;
import com.vmware.ensemble.rules.i18n.services.VendingState;

import java.util.ArrayList;
import java.util.List;

public class HasMoneyState implements VendingState {

    public HasMoneyState() {
        System.out.println("Vending Machine is in HasMoneyState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        throw new RuntimeException("Cannot click on Insert Coin Button");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Coin> coins) {
        System.out.println("Accepting coins");
        vendingMachine.setCoins(coins);
        vendingMachine.setVendingState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, String itemCode) {
        throw new RuntimeException("");
    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, Item item) {
        throw new RuntimeException("");
    }

    @Override
    public List<Coin> exit(VendingMachine vendingMachine) {
        vendingMachine.setVendingState(new ReadyState());
        List<Coin>  paidByUser = new ArrayList<>(vendingMachine.getCoins());
        vendingMachine.removeCoins();
        return paidByUser;
    }

    @Override
    public List<Coin> getChange(VendingMachine vendingMachine, int returnChangeMoney) {
        throw new RuntimeException("");
    }
}
