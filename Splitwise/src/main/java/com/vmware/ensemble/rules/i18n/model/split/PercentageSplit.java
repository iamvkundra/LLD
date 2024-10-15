package com.vmware.ensemble.rules.i18n.model.split;

import com.vmware.ensemble.rules.i18n.User;

public class PercentageSplit extends Split {

    double percentage;
    public PercentageSplit(User user, double percentage) {
        super(user);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
