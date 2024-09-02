package com.vmware.ensemble.rules.i18n.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmware.ensemble.rules.i18n.enums.LoggerLevel;
import com.vmware.ensemble.rules.i18n.enums.LoggerType;

public class LoggerConfiguration {

    private static volatile  LoggerConfiguration instance = null;
    private static LoggerLevel globalLogLevel;
    private static LoggerType loggerType;
    private static final Map<LoggerLevel, List<String>> levelSinkConfigmap = new HashMap<>();
    private final Map<LoggerLevel, LoggerType> levelLoggerTypeMap = new HashMap<>();

    public LoggerConfiguration() {
        globalLogLevel = LoggerLevel.INFO; //Default set.
        loggerType = LoggerType.SYNC; //Default set.

        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class");
        }
    }

    public static LoggerConfiguration getInstance() {
        if (instance == null) {
            synchronized (LoggerConfiguration.class) {
                if (instance == null) {
                    instance = new LoggerConfiguration();
                }
            }
         }
        return instance;
    }

    public void setGlobalLogLevel(LoggerLevel level) {
        globalLogLevel = level;
    }

    public void setLoggerType(LoggerType loggerType) {
        LoggerConfiguration.loggerType = loggerType;
    }

    public LoggerType getLoggerType(LoggerLevel level) {
        return levelLoggerTypeMap.get(level);
    }

    public void addLevelTypeConfiguration(LoggerLevel level, LoggerType loggerType) {
        if (loggerType == null) {
            return;
        }
        levelLoggerTypeMap.put(level, loggerType);
    }

    public void addLevelSinkConfiguration(LoggerLevel level, List<String> sinkTypes) {
        if (level == null || sinkTypes == null || sinkTypes.isEmpty()) {
            return;
        }
        levelSinkConfigmap.put(level, sinkTypes);
    }

    public List<String> getSinkConfig(LoggerLevel level) {
        if (level == null) {
            return new ArrayList<>();
        }
        return levelSinkConfigmap.getOrDefault(level, new ArrayList<>());
    }

    public LoggerLevel getGlobalLogLevel() {
        return globalLogLevel;
    }
}
