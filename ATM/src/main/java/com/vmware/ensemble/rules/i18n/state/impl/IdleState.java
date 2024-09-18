package com.vmware.ensemble.rules.i18n.state.impl;

import com.vmware.ensemble.rules.i18n.enums.TransactionType;
import com.vmware.ensemble.rules.i18n.model.Card;
import com.vmware.ensemble.rules.i18n.service.ATM;
import com.vmware.ensemble.rules.i18n.state.ATMState;

public class IdleState implements ATMState {


    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setAtmState(new HasCardState());

    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) throws Exception {
        throw new Exception("This state can only accept the card first.");
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) throws Exception {
        throw new Exception("This state can only accept the card first.");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) throws Exception {
        throw new Exception("This state can only accept the card first.");
    }

    @Override
    public void displayBalance(ATM atm, Card card) throws Exception {
        throw new Exception("This state can only accept the card first.");
    }

    @Override
    public void returnCard() throws Exception {
        throw new Exception("This state can only accept the card first.");
    }

    @Override
    public void exit(ATM atm) {
        atm.setAtmState(new IdleState());
    }
}
