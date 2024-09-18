package com.vmware.ensemble.rules.i18n.model.Account;

import com.vmware.ensemble.rules.i18n.model.Bid;

public abstract class User {
    private String userId;
    private String name;
    private String email;
    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public abstract void placeBid(Bid bid) throws Exception;
    public abstract void receiveNotification(long bidPrice, User user, long highestBid);
}
