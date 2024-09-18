package com.vmware.ensemble.rules.i18n.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.model.Account.Bider;
import com.vmware.ensemble.rules.i18n.model.Account.User;
import com.vmware.ensemble.rules.i18n.model.Auction;
import com.vmware.ensemble.rules.i18n.model.Bid;
import com.vmware.ensemble.rules.i18n.service.AuctionMediator;

public class AuctionMediatorImpl implements AuctionMediator {
    private String auctionMediatorId;
    private Auction auction;
    private List<User> listOfBidders;
    private List<Bid> historyOfBid;

    public AuctionMediatorImpl (String auctionMediatorId, Auction auction) {
        this.auctionMediatorId = auctionMediatorId;
        this.auction = auction;
        this.listOfBidders = new ArrayList<>();
        this.historyOfBid = new ArrayList<>();
    }
    @Override
    public void addBidder(User bider) {
        this.listOfBidders.add(bider);
    }

    @Override
    public void placeBid(Bid bid) throws Exception {
        if(!validation(bid)) {
            throw new Exception("This bidder is not register for this Auction.");
        }
        if (bid.getBiddingPrice() > auction.getHighestBidPrice()) {
            auction.setHighestBidder(bid.getUserId());
            auction.setHighestBidPrice(bid.getBiddingPrice());
        }
        for (User bider : listOfBidders) {
            String storedBidder = bider.getUserId();
            String bidUserId = bid.getUserId().getUserId();
            if (!storedBidder.equals(bidUserId)) {
                bider.receiveNotification(bid.getBiddingPrice(), bid.getUserId(), auction.getHighestBidPrice());
            }
        }
        this.historyOfBid.add(bid);
    }

    private boolean validation(Bid bid) {
        for (User bider : listOfBidders) {
            if (bider.getUserId().equals(bid.getUserId().getUserId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Auction getAuction() {
        return this.auction;
    }
}
