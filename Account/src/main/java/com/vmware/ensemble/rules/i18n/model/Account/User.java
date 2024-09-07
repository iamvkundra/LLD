package com.vmware.ensemble.rules.i18n.model.Account;

public abstract class User {
    private final String userId;
    private final String name;
    private final String emailId;
    private final Account account;

    public User(String userId, String name, String emailId, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.account = new Account(username, password);
    }


    public Account getAccount() {
        return this.account;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public abstract void login(String username, String password);
    public abstract void logout();
    public abstract void resetPassword(String username, String oldPassword, String newPassword);
}
