package com.vmware.ensemble.rules.i18n.state;

import com.vmware.ensemble.rules.i18n.enums.TransactionType;
import com.vmware.ensemble.rules.i18n.model.Card;
import com.vmware.ensemble.rules.i18n.service.ATM;

public interface ATMState {
    void insertCard(ATM atm, Card card) throws Exception;
    void authenticatePin(ATM atm, Card card, int pin) throws Exception;
    void selectOperation(ATM atm, Card card, TransactionType txnType) throws Exception;
    void cashWithdrawal(ATM atm, Card card, int withdrawAmount) throws Exception;
    void displayBalance(ATM atm, Card card) throws Exception;
    void returnCard() throws Exception;
    void exit(ATM atm) throws Exception;

}
