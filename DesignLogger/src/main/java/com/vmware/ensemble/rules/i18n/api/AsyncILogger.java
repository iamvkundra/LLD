package com.vmware.ensemble.rules.i18n.api;

import java.time.LocalDateTime;
import java.util.List;

import com.vmware.ensemble.rules.i18n.config.LoggerConfiguration;
import com.vmware.ensemble.rules.i18n.enums.LoggerLevel;

public class AsyncILogger implements ILogger {

    private LoggerConfiguration loggerConfiguration = LoggerConfiguration.getInstance();

    public AsyncILogger(int bufferSize) {

    }

    @Override
    public void log(String message, String level, LocalDateTime now) {
        LoggerLevel loggerLevel = LoggerLevel.getLevelByName(level);
        LoggerLevel globalLoggerLevel = LoggerLevel.getLevelByName(loggerConfiguration.getGlobalLogLevel().getLevel());

        if (loggerLevel.getLevelNumber() >= globalLoggerLevel.getLevelNumber()) {
            List<String> sinks = loggerConfiguration.getSinkConfig(loggerLevel);

        }
    }
}
