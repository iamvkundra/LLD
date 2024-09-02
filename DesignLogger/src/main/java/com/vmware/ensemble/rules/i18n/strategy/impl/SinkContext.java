package com.vmware.ensemble.rules.i18n.strategy.impl;

import static com.vmware.ensemble.rules.i18n.constants.LoggerConstants.CONSOLE;
import static com.vmware.ensemble.rules.i18n.constants.LoggerConstants.DATABASE;
import static com.vmware.ensemble.rules.i18n.constants.LoggerConstants.FILE;

import java.util.HashMap;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.model.Message;
import com.vmware.ensemble.rules.i18n.strategy.SinkStrategy;

public class SinkContext {

    private SinkStrategy strategy;
    private static final Map<String, SinkStrategy> strategyRegister = new HashMap<>();

    static {
        SinkContext.registerStrategy(CONSOLE, new ConsoleSinkImplementation());
        SinkContext.registerStrategy(FILE, new FileSinkImplementation());
        SinkContext.registerStrategy(DATABASE, new DataBaseSinkImplementation());
    }

    public static void registerStrategy(String strategyName, SinkStrategy strategy) {
        strategyRegister.put(strategyName, strategy);
    }

    public SinkStrategy getStrategy(String sinkName) {
        if (strategyRegister.containsKey(sinkName)) {
            return strategyRegister.get(sinkName);
        }
        return null;
    }

    public void setStrategy(SinkStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Message message) {
        this.strategy.write(message);
    }
}
