package com.vmware.ensemble.rules.i18n.api;

import java.time.LocalDateTime;
import java.util.List;

import com.vmware.ensemble.rules.i18n.config.LoggerConfiguration;
import com.vmware.ensemble.rules.i18n.enums.LoggerLevel;
import com.vmware.ensemble.rules.i18n.model.Message;
import com.vmware.ensemble.rules.i18n.strategy.SinkStrategy;
import com.vmware.ensemble.rules.i18n.strategy.impl.SinkContext;

public class SyncILogger implements ILogger{

    private static final LoggerConfiguration loggerConfiguration = LoggerConfiguration.getInstance();
    private final SinkContext sinkContext;

    public SyncILogger() {
        this.sinkContext = new SinkContext();
    }

    @Override
    public void log(String message, String level, LocalDateTime now) {
        LoggerLevel loggerLevel = LoggerLevel.getLevelByName(level);
        LoggerLevel globalLogLevel = LoggerLevel.getLevelByName(loggerConfiguration.getGlobalLogLevel().getLevel());
        if (loggerLevel.getLevelNumber() >= globalLogLevel.getLevelNumber()) {
            List<String> sinkList = loggerConfiguration.getSinkConfig(loggerLevel);
            Message messageObject = new Message(message, loggerLevel, now);
            for (String sink : sinkList) {
                SinkStrategy strategy = sinkContext.getStrategy(sink);
                sinkContext.setStrategy(strategy);
                sinkContext.executeStrategy(messageObject);
            }
        }
    }

}
