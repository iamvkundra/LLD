package com.vmware.ensemble.rules.i18n.strategy;

import com.vmware.ensemble.rules.i18n.model.Bill;

public interface PaymentStrategy {
    void processPayment(Bill bill);
}
