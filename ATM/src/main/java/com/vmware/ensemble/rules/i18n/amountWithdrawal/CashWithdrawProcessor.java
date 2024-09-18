package com.vmware.ensemble.rules.i18n.amountWithdrawal;

import com.vmware.ensemble.rules.i18n.service.ATM;

public abstract class CashWithdrawProcessor {
    private CashWithdrawProcessor cashWithdrawProcessor;

    public CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        this.cashWithdrawProcessor = cashWithdrawProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount) {
        if (cashWithdrawProcessor != null) {
            cashWithdrawProcessor.withdraw(atm, remainingAmount);
        }
    }
}
