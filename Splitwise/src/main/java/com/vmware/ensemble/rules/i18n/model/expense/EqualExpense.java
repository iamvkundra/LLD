package com.vmware.ensemble.rules.i18n.model.expense;

import java.util.List;

import com.vmware.ensemble.rules.i18n.User;
import com.vmware.ensemble.rules.i18n.model.split.ExactSplit;
import com.vmware.ensemble.rules.i18n.model.split.Split;

public class EqualExpense extends Expense {

    public EqualExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(amount, expensePaidBy, splits, expenseData);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit)) return false;
        }
        return true;
    }
}
