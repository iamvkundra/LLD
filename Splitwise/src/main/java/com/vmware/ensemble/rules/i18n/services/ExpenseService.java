package com.vmware.ensemble.rules.i18n.services;

import java.util.List;

import com.vmware.ensemble.rules.i18n.User;
import com.vmware.ensemble.rules.i18n.enums.ExpenseType;
import com.vmware.ensemble.rules.i18n.model.expense.EqualExpense;
import com.vmware.ensemble.rules.i18n.model.expense.ExactExpense;
import com.vmware.ensemble.rules.i18n.model.expense.Expense;
import com.vmware.ensemble.rules.i18n.model.expense.ExpenseData;
import com.vmware.ensemble.rules.i18n.model.expense.PercentageExpense;
import com.vmware.ensemble.rules.i18n.model.split.PercentageSplit;
import com.vmware.ensemble.rules.i18n.model.split.Split;

public class ExpenseService {

    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splitList, ExpenseData expenseData) {
        switch (expenseType) {
            case PERCENTAGE:
                for (Split split: splitList) {
                    PercentageSplit percentageSplit = (PercentageSplit) split;
                    split.setSplitAmount((amount*percentageSplit.getPercentage())/100.0);
                }
                return new PercentageExpense(amount, paidBy, splitList, expenseData);
            case EQUAL:
                int totalSplit = splitList.size();
                double splitAmount = ((double) Math.round(amount*100/totalSplit))/100.0;
                for (Split split : splitList) {
                    split.setSplitAmount(splitAmount);
                }
                return new EqualExpense(amount, paidBy, splitList, expenseData);
            case EXACT:
                return new ExactExpense(amount, paidBy, splitList, expenseData);
            default:
                return null;
        }
    }
}
