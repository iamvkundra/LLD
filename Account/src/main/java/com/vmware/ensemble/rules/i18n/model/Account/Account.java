package com.vmware.ensemble.rules.i18n.model.Account;

public class Account {

    private final String username;
    private String password;
    private boolean isLoggedIn;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.isLoggedIn = true;
            System.out.println("Successfully Logged In : username: " + getUsername());
        }
    }

    public void logout(){
        this.isLoggedIn = false;
        System.out.println("Successfully logout");
    }

    public String getUsername() {
        return username;
    }

    public void resetPassword(String username, String oldPassword, String newPassword) {
        if (this.username.equals(username) && this.password.equals(oldPassword)) {
            this.password = newPassword;
        }
    }

}
