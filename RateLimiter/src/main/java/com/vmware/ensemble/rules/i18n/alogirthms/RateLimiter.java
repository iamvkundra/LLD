package com.vmware.ensemble.rules.i18n.alogirthms;

@FunctionalInterface
public interface RateLimiter {
    boolean acceptRequest();
}
