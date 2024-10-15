package com.vmware.ensemble.rules.i18n.strategy.impl;

import com.vmware.ensemble.rules.i18n.model.Bill;
import com.vmware.ensemble.rules.i18n.strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(Bill bill) {
        System.out.printf("Processed credit card payment of $%.2f for ticket %d%n",
                bill.getAmount(), bill.getTicket().getTicketId());
    }
}