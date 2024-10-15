package com.vmware.ensemble.rules.i18n.services;

public class VendingMachine {

    public static VendingMachine vendingMachine;
    public VendingState vendingState;

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
}
