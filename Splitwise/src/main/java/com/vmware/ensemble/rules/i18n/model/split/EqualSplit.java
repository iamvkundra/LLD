package com.vmware.ensemble.rules.i18n.model.split;

import com.vmware.ensemble.rules.i18n.User;

public class EqualSplit extends Split {

    public EqualSplit(User user, int amount) {
        super(user);
        this.setSplitAmount(amount);
    }

}
