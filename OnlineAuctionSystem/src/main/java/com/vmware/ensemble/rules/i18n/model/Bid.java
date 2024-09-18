package com.vmware.ensemble.rules.i18n.model;

import com.vmware.ensemble.rules.i18n.model.Account.User;

public class Bid {
    private String bidId;
    private User user;
    private String auctionId;
    private long biddingPrice;

    public Bid(String bidId, User user, String auctionId, long biddingPrice) {
        this.biddingPrice = biddingPrice;
        this.bidId = bidId;
        this.auctionId = auctionId;
        this.user = user;
    }

    public String getBidId() {
        return bidId;
    }

    public User getUserId() {
        return user;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public long getBiddingPrice() {
        return biddingPrice;
    }
}
