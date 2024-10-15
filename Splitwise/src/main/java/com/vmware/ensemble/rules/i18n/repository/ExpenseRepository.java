package com.vmware.ensemble.rules.i18n.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.User;
import com.vmware.ensemble.rules.i18n.enums.ExpenseType;
import com.vmware.ensemble.rules.i18n.model.expense.Expense;
import com.vmware.ensemble.rules.i18n.model.expense.ExpenseData;
import com.vmware.ensemble.rules.i18n.model.split.Split;
import com.vmware.ensemble.rules.i18n.services.ExpenseService;

public class ExpenseRepository {

    private final List<Expense> expenseList;

    private final Map<String, User> userMap;
    /*UserId -> [Whom to Pay what amount, UserId, amount] */
    private final Map<String, Map<String, Double>> balanceSheet;

    public ExpenseRepository(){
        this.userMap = new HashMap<>();
        this.balanceSheet = new HashMap<>();
        this.expenseList = new ArrayList<>();
    }

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
        balanceSheet.put(user.getUserId(), new HashMap<>());
    }

    public User getUser(String userId) {
        return this.userMap.get(userId);
    }

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseData expenseData) {
        Expense expense = ExpenseService.createExpense(expenseType, amount, userMap.get(paidBy), splits, expenseData);
        expenseList.add(expense);
        assert expense != null;
        for (Split split : expense.getSplits()) {
            String paidTo = split.getUser().getUserId();
            Map<String, Double> balances = balanceSheet.get(paidBy);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getSplitAmount());

            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getSplitAmount());
        }
    }

    public List<String> getBalance(String userId) {
        List<String> balances = new ArrayList<>();
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() > 0) {
                balances.add(checkSign(userMap.get(userId).getUserId(), userBalance.getKey(), userBalance.getValue()));
            }
        }
        return balances;
    }

    public List<String> getBalance() {
        List<String> balances = new ArrayList<>();
        return balances;
    }

    private String checkSign(String user1, String user2, double amount) {
        String user1Name = userMap.get(user1).getName();
        String user2Name = userMap.get(user2).getName();
        if (amount < 0) {
            return  user1Name + " owes " + user2Name + ": " + Math.abs(amount);
        } else if (amount > 0) {
            return user2Name + " owes " + user1Name + ": " + Math.abs(amount);
        }
        return "";
    }
}
