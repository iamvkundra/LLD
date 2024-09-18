package com.vmware.ensemble.rules.i18n.state.impl;

import com.vmware.ensemble.rules.i18n.enums.TransactionType;
import com.vmware.ensemble.rules.i18n.model.Card;
import com.vmware.ensemble.rules.i18n.service.ATM;
import com.vmware.ensemble.rules.i18n.state.ATMState;

public class SelectOperationState implements ATMState {

    public SelectOperationState() {
        showOperations();
    }
    @Override
    public void insertCard(ATM atm, Card card) throws Exception {
        throw new Exception("");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) throws Exception {
        throw new Exception("");
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) throws Exception {
        switch (txnType) {

            case CASH_WITHDRAWAL:
                atm.setCurrentATMState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atm.setCurrentATMState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atm);
            }
        }
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) throws Exception {

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
        System.out.println("Successfully Exited");
    }

    private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }

}
