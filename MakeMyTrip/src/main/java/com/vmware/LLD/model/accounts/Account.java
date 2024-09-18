package com.vmware.LLD.model.accounts;

public abstract class Account {

    private final String username;
    private String password;
    private User user;
    private boolean isLoggedIn;

    public Account(String username, String password, User user) {
        this.username = username;
        this.password = password;
        this.user = user;
        this.isLoggedIn = false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.setLoggedIn(true);
            return;
        }
        System.out.println("Please provide correct username/password");
    }

    public void logout() {
        if (this.isLoggedIn()) {
            this.setLoggedIn(false);
        }
    }

    public void resetPassword(String username, String oldPassword, String newPassword) {
        if (this.getUsername().equals(username) && this.password.equals(oldPassword)) {
            this.password = newPassword;
            System.out.println("Password successfully changed for username: "+username);
        }
    }
}

