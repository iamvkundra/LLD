package com.vmware.ensemble.rules.i18n;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.w3c.dom.Node;

import com.vmware.ensemble.rules.i18n.enums.TransactionType;
import com.vmware.ensemble.rules.i18n.model.Card;
import com.vmware.ensemble.rules.i18n.model.User;
import com.vmware.ensemble.rules.i18n.model.UserBankAccount;
import com.vmware.ensemble.rules.i18n.service.ATM;

public class Main {

    private ATM atm;
    private User user;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.init();

        main.atm.printCurrentATMStatus();
        main.atm.getAtmState().insertCard(main.atm, main.user.card);
        main.atm.getAtmState().authenticatePin(main.atm, main.user.card, 112211);
        main.atm.getAtmState().selectOperation(main.atm, main.user.card, TransactionType.CASH_WITHDRAWAL);
        main.atm.getAtmState().cashWithdrawal(main.atm, main.user.card, 2700);
        main.atm.printCurrentATMStatus();

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value  - o1.value;
            }
        });
        class Node {

        }
    }

    private void init() {
        atm = ATM.getInstance();
        atm.setAtmBalance(3500, 1, 2, 5);

        //Create User
        user = new User();
        user.setCard(createCard());
    }

    private Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount() {
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.setBalance(3000);

        return bankAccount;

    }
}