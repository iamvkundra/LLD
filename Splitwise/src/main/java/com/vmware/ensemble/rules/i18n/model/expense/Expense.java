package com.vmware.ensemble.rules.i18n.model.expense;

import java.util.List;
import java.util.UUID;

import com.vmware.ensemble.rules.i18n.User;
import com.vmware.ensemble.rules.i18n.model.split.Split;

public abstract class Expense {

    private String expenseId;
    private double amount;
    private User expensePaidBy;
    private List<Split> splits;
    private ExpenseData expenseData;

    public Expense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        this.expenseId = UUID.randomUUID().toString();
        this.amount = amount;
        this.expensePaidBy = expensePaidBy;
        this.splits = splits;
        this.expenseData = expenseData;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getExpensePaidBy() {
        return expensePaidBy;
    }

    public void setExpensePaidBy(User expensePaidBy) {
        this.expensePaidBy = expensePaidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ExpenseData getExpenseData() {
        return expenseData;
    }

    public void setExpenseData(ExpenseData expenseData) {
        this.expenseData = expenseData;
    }

    public abstract boolean validate();
}
