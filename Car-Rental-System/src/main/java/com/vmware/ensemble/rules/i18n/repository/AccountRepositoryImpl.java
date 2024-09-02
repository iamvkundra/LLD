package com.vmware.ensemble.rules.i18n.repository;

import java.util.HashMap;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.exceptions.AccountDoesNotExistsException;
import com.vmware.ensemble.rules.i18n.model.account.Account;
import com.vmware.ensemble.rules.i18n.repository.interfaces.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<String, Account> accountMap;

    public AccountRepositoryImpl() {
        this.accountMap = new HashMap<>();
    }

    @Override
    public Account createAccount(Account account) {
        this.accountMap.put(account.getId(), account);
        System.out.println("Account Created: accountId: " + account.getId());
        return accountMap.get(account.getId());
    }

    @Override
    public void resetPassword(String userId, String password) throws AccountDoesNotExistsException {
        Account account = accountMap.get(userId);
        if (account == null) {
            throw new AccountDoesNotExistsException();
        }
        account.resetPassword(password);
        accountMap.put(userId, account);
        System.out.println("Password successfully reset. username: " + userId);
    }
}
