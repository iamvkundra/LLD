package com.vmware.ensemble.rules.i18n.model.Account;

public class Member extends User {

    private String studentId;

    public Member(String userId, String name, String emailId, String username, String password) {
        super(userId, name, emailId, username, password);
    }

    @Override
    public void login(String username, String password) {
        getAccount().login(username, password);
    }


    @Override
    public void logout() {
       getAccount().logout();
    }

    @Override
    public void resetPassword(String username, String oldPassword, String newPassword) {
        getAccount().resetPassword(username, oldPassword, newPassword);
    }
}
