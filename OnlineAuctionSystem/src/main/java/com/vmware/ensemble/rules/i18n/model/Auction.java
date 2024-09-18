package com.vmware.ensemble.rules.i18n.model;

import java.time.LocalDateTime;

import com.vmware.ensemble.rules.i18n.model.Account.User;

public class Auction {

    private String auctionId;
    private String auctionName;
    private Item item;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long highestBidPrice;
    private User highestBidder;

    public Auction(String auctionId, String auctionName, Item item, LocalDateTime startTime, LocalDateTime endTime) {
        this.auctionId = auctionId;
        this.auctionName = auctionName;
        this.item = item;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setHighestBidder(User highestBidder) {
        this.highestBidder = highestBidder;
    }

    public void setHighestBidPrice(long highestBidPrice) {
        this.highestBidPrice = highestBidPrice;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public Item getItem() {
        return item;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public long getHighestBidPrice() {
        return highestBidPrice;
    }

    public User getHighestBidder() {
        return highestBidder;
    }
}
