package com.vmware.ensemble.rules.i18n.strategy.impl;

import com.vmware.ensemble.rules.i18n.model.Message;
import com.vmware.ensemble.rules.i18n.strategy.SinkStrategy;

public class DataBaseSinkImplementation implements SinkStrategy {
    @Override
    public void write(Message message) {
        System.out.println("[DATABASE]["+ message.getLoggerLevel().getLevel() + "]" +
                "[timestamp: " + message.getEpoch().toString() + "]" + "[message: " +
                message.getMessage() + "]");
    }
}