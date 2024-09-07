package com.vmware.ensemble.rules.i18n.model.Account;

public class Librarian extends User {

    public Librarian(String userId, String name, String emailId, String username, String password) {
        super(userId, name, emailId, username, password);
    }

    public void addBook() {
        if (getAccount().isLoggedIn()) {
            System.out.println("Logged in and able to add books");
        }else {
            System.out.println("Please login before you add books");
        }
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
