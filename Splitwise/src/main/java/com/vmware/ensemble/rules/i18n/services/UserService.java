package com.vmware.ensemble.rules.i18n.services;

import com.vmware.ensemble.rules.i18n.User;
import com.vmware.ensemble.rules.i18n.repository.ExpenseRepository;

public class UserService {

    private final ExpenseRepository expenseRepository;

    public UserService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addUser(User user) {
        this.expenseRepository.addUser(user);
    }

    public User getUser(String userId) {
        return this.expenseRepository.getUser(userId);
    }
}
