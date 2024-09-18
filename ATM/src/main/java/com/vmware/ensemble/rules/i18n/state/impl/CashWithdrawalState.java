package com.vmware.ensemble.rules.i18n.state.impl;

import com.vmware.ensemble.rules.i18n.amountWithdrawal.FiveHundredWithdrawProcessor;
import com.vmware.ensemble.rules.i18n.amountWithdrawal.OneHundredWithdrawProcessor;
import com.vmware.ensemble.rules.i18n.amountWithdrawal.TwoThousandWithdrawProcessor;
import com.vmware.ensemble.rules.i18n.enums.TransactionType;
import com.vmware.ensemble.rules.i18n.model.Card;
import com.vmware.ensemble.rules.i18n.service.ATM;
import com.vmware.ensemble.rules.i18n.amountWithdrawal.CashWithdrawProcessor;
import com.vmware.ensemble.rules.i18n.state.ATMState;

public class CashWithdrawalState implements ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
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
        throw new Exception("");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmountRequest) throws Exception {
        if (atm.getAtmBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atm);
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atm);
        } else {

            card.deductBankBalance(withdrawalAmountRequest);
            atm.deductATMBalance(withdrawalAmountRequest);

            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atm, withdrawalAmountRequest);
            exit(atm);
        }

    }

    @Override
    public void displayBalance(ATM atm, Card card) throws Exception {
        throw new Exception("");
    }

    @Override
    public void returnCard() throws Exception {
        System.out.println("Please collect your card");
    }

    @Override
    public void exit(ATM atm) throws Exception {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");

    }
}
