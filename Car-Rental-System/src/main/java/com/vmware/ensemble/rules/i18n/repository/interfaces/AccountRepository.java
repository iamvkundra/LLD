package com.vmware.ensemble.rules.i18n.repository.interfaces;

import com.vmware.ensemble.rules.i18n.exceptions.AccountDoesNotExistsException;
import com.vmware.ensemble.rules.i18n.model.account.Account;

public interface AccountRepository {
    Account createAccount(Account account);
    void resetPassword(String userId, String password) throws AccountDoesNotExistsException;
}
