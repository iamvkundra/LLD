package com.vmware.ensemble.rules.i18n.model;

public class UserBankAccount {

    int balance;

    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }

    public void setBalance(int value) {
        this.balance = value;
    }
}
