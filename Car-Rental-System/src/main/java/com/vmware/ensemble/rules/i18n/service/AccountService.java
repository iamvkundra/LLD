package com.vmware.ensemble.rules.i18n.service;

import com.vmware.ensemble.rules.i18n.exceptions.AccountDoesNotExistsException;
import com.vmware.ensemble.rules.i18n.model.account.Account;
import com.vmware.ensemble.rules.i18n.repository.interfaces.AccountRepository;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) throws Exception {
        if (!validationAndCheck(account)) {
            throw new Exception();
        }
        this.accountRepository.createAccount(account);
    }

    public void resetPassword(String username, String password) throws AccountDoesNotExistsException {
        this.accountRepository.resetPassword(username, password);
    }

    private boolean validationAndCheck(Account account) {
        return true;
    }

}
