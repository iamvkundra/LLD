package com.vmware.ensemble.rules.i18n.alogirthms;

import java.util.Queue;

public class SlidingWindow implements RateLimiter {

    private Queue<Long> queue;
    private long timeWindowInSeconds;
    private long bucketSize;

    public SlidingWindow(long bucketSize, long timeWindowInSeconds) {
        this.bucketSize = bucketSize;
        this.timeWindowInSeconds = timeWindowInSeconds;
    }

    @Override
    public synchronized boolean acceptRequest() {
        Long currentTime = System.nanoTime();
        checkAndUpdateWindow(currentTime);
        if (queue.size() < bucketSize) {
            queue.offer(currentTime);
            return true;
        }
        return false;
    }

    private void checkAndUpdateWindow(Long currentTime) {
        if (queue.isEmpty()) return;

        long time = (currentTime - queue.peek())/1000;
        System.out.println("Time " + time);
        while(!queue.isEmpty() && time >= timeWindowInSeconds) {
            queue.poll();
            System.out.println("Queue Peek Time: " + queue.peek());
            if (!queue.isEmpty()) time = (currentTime - queue.peek())/1000;
        }

    }
}
