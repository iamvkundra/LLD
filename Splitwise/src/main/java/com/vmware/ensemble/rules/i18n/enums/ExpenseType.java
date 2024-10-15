package com.vmware.ensemble.rules.i18n.enums;

import java.util.HashMap;
import java.util.Map;

public enum ExpenseType {

    EQUAL("EQUAL"),
    EXACT("EXACT"),
    PERCENTAGE("PERCENTAGE");

    private final String expense;
    ExpenseType(String value) {
        this.expense = value;
    }

    public String toString() {
        return this.expense;
    }

    public static Map<String, ExpenseType> map = new HashMap<>();

    static  {
        for (ExpenseType expenseType : values()) {
            map.put(expenseType.expense, expenseType);
        }
    }
    public static ExpenseType of(String name) {
        return  map.get(name);
    }
}
