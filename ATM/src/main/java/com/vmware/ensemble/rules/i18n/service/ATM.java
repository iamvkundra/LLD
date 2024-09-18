package com.vmware.ensemble.rules.i18n.service;

import com.vmware.ensemble.rules.i18n.state.ATMState;
import com.vmware.ensemble.rules.i18n.state.impl.IdleState;

public class ATM {

    private ATMState atmState;
    public static ATM atm;

    private int atmBalance;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;

    public ATM() {
        this.atmState = new IdleState();
    }
    public static ATM getInstance() {
        if (atm == null) {
            synchronized (ATM.class) {
                if (atm == null) {
                    atm = new ATM();
                }
            }
        }
        return atm;
    }

    public int getAtmBalance() {
        return this.atmBalance;
    }

    public void setCurrentATMState(ATMState currentATMState) {
        this.atmState = currentATMState;
    }

    public ATMState getAtmState() {
        return this.atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }


}
