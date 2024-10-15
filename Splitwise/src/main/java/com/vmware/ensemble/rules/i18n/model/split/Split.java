package com.vmware.ensemble.rules.i18n.model.split;

import com.vmware.ensemble.rules.i18n.User;

public abstract class Split {

    private String splitId;
    private User user;
    private double splitAmount;

    public Split(User user) {
        this.user = user;
    }

    public String getSplitId() {
        return splitId;
    }

    public void setSplitId(String splitId) {
        this.splitId = splitId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(double splitAmount) {
        this.splitAmount = splitAmount;
    }
}
