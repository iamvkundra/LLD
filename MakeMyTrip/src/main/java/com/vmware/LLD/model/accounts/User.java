package com.vmware.LLD.model.accounts;

public class User {

    private String userId;
    private String name;
    private String email;

    public User(String userId, String name, String email) {
        this.email = email;
        this.name = name;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String userName) {
        this.name = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
