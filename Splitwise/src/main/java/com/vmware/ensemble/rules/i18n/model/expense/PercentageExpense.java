package com.vmware.ensemble.rules.i18n.model.expense;

import java.util.List;

import com.vmware.ensemble.rules.i18n.User;
import com.vmware.ensemble.rules.i18n.model.split.ExactSplit;
import com.vmware.ensemble.rules.i18n.model.split.PercentageSplit;
import com.vmware.ensemble.rules.i18n.model.split.Split;

public class PercentageExpense extends Expense {

    public PercentageExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(amount, expensePaidBy, splits, expenseData);
    }

    @Override
    public boolean validate() {
        double totalAmount = this.getAmount();
        double totalSplitAmount = 0;
        for (Split split : getSplits()) {
            if (!(split instanceof PercentageSplit)) return false;
            PercentageSplit percentageSplit = (PercentageSplit) split;
            totalSplitAmount += percentageSplit.getPercentage();
        }
        return 100 == totalSplitAmount;
    }
}
