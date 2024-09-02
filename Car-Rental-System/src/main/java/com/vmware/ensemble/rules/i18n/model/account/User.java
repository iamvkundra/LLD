package com.vmware.ensemble.rules.i18n.model.account;

public class User extends Account{
    private LicenseInfo licenseInfo;

    public User(String id, String email, String username, String password, Contact contact) {
        super(id, email, username, password, contact);
    }
}
