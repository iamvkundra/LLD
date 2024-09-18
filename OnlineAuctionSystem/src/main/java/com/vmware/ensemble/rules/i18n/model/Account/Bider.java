package com.vmware.ensemble.rules.i18n.model.Account;

import com.vmware.ensemble.rules.i18n.model.Bid;
import com.vmware.ensemble.rules.i18n.service.OnlineAuctionService;

public class Bider extends User {

    private final OnlineAuctionService onlineAuctionService = OnlineAuctionService.getInstance();

    public Bider(String userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public void placeBid(Bid bid) throws Exception {
        onlineAuctionService.placeBid(bid);
    }

    @Override
    public void receiveNotification(long bidPrice, User user, long highestBid) {
        System.out.println("New Bid is placed for your registered auction: "+ bidPrice);

    }
}
