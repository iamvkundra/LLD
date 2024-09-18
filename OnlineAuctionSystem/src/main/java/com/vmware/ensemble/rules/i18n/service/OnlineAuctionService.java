package com.vmware.ensemble.rules.i18n.service;

import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.model.Account.Bider;
import com.vmware.ensemble.rules.i18n.model.Account.User;
import com.vmware.ensemble.rules.i18n.model.Bid;

public class OnlineAuctionService {

    public static volatile  OnlineAuctionService onlineAuctionService;

    private List<AuctionMediator> auctionMediatorList;

    public OnlineAuctionService () {
        this.auctionMediatorList = new ArrayList<>();
    }

    public static OnlineAuctionService getInstance() {
        if (onlineAuctionService == null) {
            synchronized (OnlineAuctionService.class) {
                if (onlineAuctionService == null) {
                    onlineAuctionService = new OnlineAuctionService();
                }
            }
        }
        return onlineAuctionService;
    }

    public void addAuction(AuctionMediator auctionMediator) {
        auctionMediatorList.add(auctionMediator);
    }

    public void registerIntoAuction(User bider, String auctionId) {
        for (AuctionMediator auctionMediator : auctionMediatorList) {
            if (auctionMediator.getAuction().getAuctionId().equals(auctionId)) {
                auctionMediator.addBidder(bider);
                break;
            }
        }
    }

    public void placeBid(Bid bid) throws Exception {
        AuctionMediator auctionMediator = null;
        for (AuctionMediator mediator : auctionMediatorList) {
            if (mediator.getAuction().getAuctionId().equals(bid.getAuctionId())) {
                auctionMediator = mediator;
                break;
            }
        }
        auctionMediator.placeBid(bid);
    }
}
