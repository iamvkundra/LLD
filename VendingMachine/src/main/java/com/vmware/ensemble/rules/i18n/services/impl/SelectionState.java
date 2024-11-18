package com.vmware.ensemble.rules.i18n.services.impl;

import com.vmware.ensemble.rules.i18n.enums.Coin;
import com.vmware.ensemble.rules.i18n.model.Item;
import com.vmware.ensemble.rules.i18n.model.Product;
import com.vmware.ensemble.rules.i18n.services.VendingMachine;
import com.vmware.ensemble.rules.i18n.services.VendingState;

import java.util.List;

public class SelectionState implements VendingState {

    public SelectionState() {
        System.out.println("Vending machine selection state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        throw new RuntimeException("");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, List<Coin> coins) {
        throw new RuntimeException("Cannot insert coin now");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, String itemCode) {
        Item item  = vendingMachine.getItem(itemCode);
        int paidByUser = 0;
        for (Coin coin : vendingMachine.getCoins()) {
            paidByUser += coin.getValue();
        }

        if (paidByUser < item.getProduct().getPrice()) {
            throw new RuntimeException("Cannot choose product above than paid coins");
        }else {
            paidByUser -= item.getProduct().getPrice();
            getChange(vendingMachine, paidByUser);
            vendingMachine.setVendingState(new DispenseState(vendingMachine, item));
        }

    }

    @Override
    public Product dispenseProduct(VendingMachine vendingMachine, Item item) {
        throw new RuntimeException("");
    }

    @Override
    public List<Coin> exit(VendingMachine vendingMachine) {
        vendingMachine.setVendingState(new ReadyState());
        return vendingMachine.getCoins();
    }

    @Override
    public List<Coin> getChange(VendingMachine vendingMachine, int returnChangeMoney) {
        throw new RuntimeException("");
    }
}
