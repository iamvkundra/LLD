package com.vmware.ensemble.rules.i18n.alogirthms;

public class TokenBucket implements RateLimiter {

    private final long maxBucketSize;
    private final long refillRate;
    private double currentBucketSize;
    private long lastRefillTimeStamp;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate =refillRate;
        this.currentBucketSize = maxBucketSize;
        this.lastRefillTimeStamp = System.nanoTime();
    }

    @Override
    public synchronized boolean acceptRequest() {
        reFill();
        if (currentBucketSize >= 1) {
            currentBucketSize -= 1;
            return true;
        }
        return false;
    }

    private void reFill() {
        long now = System.nanoTime();
        double tokenToAdd = (now-lastRefillTimeStamp)*refillRate/1e9;
        System.out.println("Before reFilled: " + currentBucketSize + " ");
        currentBucketSize = Math.min(currentBucketSize + tokenToAdd, maxBucketSize);
        System.out.println("After reFilled: " + currentBucketSize);
        lastRefillTimeStamp = now;
    }
}
