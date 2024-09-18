package com.vmware.ensemble.rules.i18n.model.Account;

import com.vmware.ensemble.rules.i18n.model.Bid;

public class Admin extends User {

    public Admin(String userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public void placeBid(Bid bid) {

    }

    @Override
    public void receiveNotification(long bidPrice, User user, long highestBid) {

    }
}
