package com.vmware.ensemble.rules.i18n;

import java.time.LocalDateTime;

import com.vmware.ensemble.rules.i18n.model.Account.Bider;
import com.vmware.ensemble.rules.i18n.model.Account.User;
import com.vmware.ensemble.rules.i18n.model.Auction;
import com.vmware.ensemble.rules.i18n.model.Bid;
import com.vmware.ensemble.rules.i18n.model.Item;
import com.vmware.ensemble.rules.i18n.service.AuctionMediator;
import com.vmware.ensemble.rules.i18n.service.Impl.AuctionMediatorImpl;
import com.vmware.ensemble.rules.i18n.service.OnlineAuctionService;

public class Main {
    public static void main(String[] args) throws Exception {
        OnlineAuctionService onlineAuctionService = OnlineAuctionService.getInstance();

        User seller = new Bider("seller1", "seller", "");
        User bidder1 = new Bider("bidder1", "sarvesh", "as@gmail.com");
        User bidder2 = new Bider("bidder2", "sarvesh", "as@gmail.com");

        Auction auction = new Auction("id1", "auction1",
                new Item("item1", "item1", "", 1000, seller)
                , LocalDateTime.now(), LocalDateTime.now());

        AuctionMediator auctionMediator = new AuctionMediatorImpl(auction.getAuctionId(), auction);
        onlineAuctionService.addAuction(auctionMediator);

        onlineAuctionService.registerIntoAuction(bidder1, "id1");
        onlineAuctionService.registerIntoAuction(bidder2, "id1");
        bidder1.placeBid(new Bid("bid1", bidder1, "id1", 1000));

    }

    public static void addAuctionMediator(OnlineAuctionService onlineAuctionService, User seller) {

    }

}