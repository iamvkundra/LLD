package com.vmware.ensemble.rules.i18n.strategy;

import com.vmware.ensemble.rules.i18n.model.Message;

@FunctionalInterface
public interface SinkStrategy {
    void write(Message message);
}
