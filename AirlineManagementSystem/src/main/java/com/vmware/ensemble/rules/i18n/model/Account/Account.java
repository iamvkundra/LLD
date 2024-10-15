package com.vmware.ensemble.rules.i18n.model.Account;

public abstract class Account {

    private String username;
    private String password;
    private User user;
    private boolean isLoggedIn;

    public Account(String username, String password, User user) {
        this.username = username;
        this.password = password;
        this.user = user;
    }

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            isLoggedIn = true;
            return true;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public void logout() {
        this.isLoggedIn = false;
    }

    public void resetPassword(String username, String oldPassword, String newPassword) {
        if (this.username.equals(username) && this.password.equals(oldPassword)) {
            setPassword(newPassword);
        }
        logout();
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
