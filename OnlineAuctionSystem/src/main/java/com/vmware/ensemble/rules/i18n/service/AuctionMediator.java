package com.vmware.ensemble.rules.i18n.service;

import com.vmware.ensemble.rules.i18n.model.Account.Bider;
import com.vmware.ensemble.rules.i18n.model.Account.User;
import com.vmware.ensemble.rules.i18n.model.Auction;
import com.vmware.ensemble.rules.i18n.model.Bid;

public interface AuctionMediator {
    void addBidder(User bider);
    void placeBid(Bid bid) throws Exception;
    Auction getAuction();
}
