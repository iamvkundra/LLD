package com.vmware.ensemble.rules.i18n.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.api.AsyncILogger;
import com.vmware.ensemble.rules.i18n.api.ILogger;
import com.vmware.ensemble.rules.i18n.api.SyncILogger;
import com.vmware.ensemble.rules.i18n.config.LoggerConfiguration;
import com.vmware.ensemble.rules.i18n.enums.LoggerLevel;
import com.vmware.ensemble.rules.i18n.enums.LoggerType;

public class Logger {

    private static final LoggerConfiguration loggerConfiguration = LoggerConfiguration.getInstance();
    private static final Map<LoggerType, ILogger> loggerTypeFactoryMap = new HashMap<>();
    private static volatile Logger logger;
    static {
        loggerTypeFactoryMap.put(LoggerType.SYNC, new SyncILogger());
        loggerTypeFactoryMap.put(LoggerType.ASYNC, new AsyncILogger(25));
    }

    public Logger() {
        if (logger != null) {
            throw new RuntimeException("Please use logger getLogger() methond to get the singleton instance");
        }
    }

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void addLoggerConfig(String level, LoggerType loggerType, List<String> sinks) {
        LoggerLevel loggerLevel = LoggerLevel.getLevelByName(level);
        loggerConfiguration.addLevelSinkConfiguration(loggerLevel, sinks);
        loggerConfiguration.addLevelTypeConfiguration(loggerLevel, loggerType);
    }

    public void log(String message, String loglevel, LocalDateTime now) {
        LoggerLevel logLevel = LoggerLevel.getLevelByName(loglevel);
        ILogger logger = loggerTypeFactoryMap.get(loggerConfiguration.getLoggerType(logLevel));
        logger.log(message, loglevel, now);
    }

    public void setLoggerLevel(LoggerLevel loggerLevel) {
        loggerConfiguration.setGlobalLogLevel(loggerLevel);
    }

    public void setLoggerType(LoggerType loggerType) {
        loggerConfiguration.setLoggerType(loggerType);
    }

    public void setBufferSize(int bufferSize) {
        //async not implemented.
    }
}
