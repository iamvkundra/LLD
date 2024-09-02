package com.vmware.ensemble.rules.i18n;

public class T20MatchType implements MatchType {
    @Override
    public int noOfOvers() {
        return 20;
    }

    @Override
    public int maxOverCountBowlers() {
        return 5;
    }
}
