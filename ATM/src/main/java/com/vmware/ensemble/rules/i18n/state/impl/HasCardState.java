package com.vmware.ensemble.rules.i18n.state.impl;

import com.vmware.ensemble.rules.i18n.enums.TransactionType;
import com.vmware.ensemble.rules.i18n.model.Card;
import com.vmware.ensemble.rules.i18n.service.ATM;
import com.vmware.ensemble.rules.i18n.state.ATMState;

public class HasCardState implements ATMState {

    public HasCardState() {
        System.out.println("enter your card pin number");
    }

    @Override
    public void insertCard(ATM atm, Card card) throws Exception {
        throw new Exception("CARD IS ALREADY INSERTED, PLEASE PROVIDE THE PIN.");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) throws Exception {
        boolean authenticate = card.isCorrectPINEntered(pin);
        if (authenticate) {
            atm.setAtmState(new SelectOperationState());
        } else {
          System.out.println("Entered PIN is invalid.");
          exit(atm);
        }
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) throws Exception {
        throw new Exception("");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) throws Exception {
        throw new Exception("");
    }

    @Override
    public void displayBalance(ATM atm, Card card) throws Exception {
        throw new Exception("");
    }

    @Override
    public void returnCard() throws Exception {
        System.out.println("Please collect your card.");
    }

    @Override
    public void exit(ATM atm) throws Exception {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Successfully exited");
    }
}
