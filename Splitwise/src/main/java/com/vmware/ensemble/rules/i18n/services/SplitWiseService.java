package com.vmware.ensemble.rules.i18n.services;

import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.ExpenseType;
import com.vmware.ensemble.rules.i18n.model.expense.ExpenseData;
import com.vmware.ensemble.rules.i18n.model.split.Split;
import com.vmware.ensemble.rules.i18n.repository.ExpenseRepository;

public class SplitWiseService {

    private final ExpenseRepository expenseRepository;

    public SplitWiseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(ExpenseType expenseType, double amount, String expensePaidBy, List<Split> splitList, ExpenseData expenseData) {
        expenseRepository.addExpense(expenseType, amount, expensePaidBy, splitList, expenseData);
    }

    public List<String> showBalance(String userId) {
        return expenseRepository.getBalance(userId);
    }

    public void showBalances() {
        List<String> balances = expenseRepository.getBalance();
        if(balances.isEmpty()) {
            System.out.println("No Balance");
        }else {
            for (String bal : balances) {
                System.out.println(bal);
            }
        }
    }
}
