package com.vmware.ensemble.rules.i18n.services;


import com.vmware.ensemble.rules.i18n.enums.Coin;
import com.vmware.ensemble.rules.i18n.model.Item;
import com.vmware.ensemble.rules.i18n.model.Product;

import java.util.List;

public interface VendingState {
    void clickOnInsertCoinButton(VendingMachine vendingMachine);
    void insertCoin(VendingMachine vendingMachine, List<Coin> coins);
    void chooseProduct(VendingMachine vendingMachine, String itemCode);
    Product dispenseProduct(VendingMachine vendingMachine, Item item);
    List<Coin> exit(VendingMachine vendingMachine);
    List<Coin> getChange(VendingMachine vendingMachine, int returnChangeMoney);
}
