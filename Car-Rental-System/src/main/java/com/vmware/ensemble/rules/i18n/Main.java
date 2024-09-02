package com.vmware.ensemble.rules.i18n;

import java.util.UUID;

import com.vmware.ensemble.rules.i18n.model.account.Account;
import com.vmware.ensemble.rules.i18n.model.account.Contact;
import com.vmware.ensemble.rules.i18n.model.account.User;
import com.vmware.ensemble.rules.i18n.repository.AccountRepositoryImpl;
import com.vmware.ensemble.rules.i18n.repository.interfaces.AccountRepository;
import com.vmware.ensemble.rules.i18n.service.AccountService;


public class Main {

    public static String getRandomId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("-------------------CAR RENTAL SYSTEM--------------------------");

        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountService(accountRepository);

        Account account = new User("1","xyz@gmail.com", "username","password",
                new Contact());

        accountService.createAccount(account);



    }
}