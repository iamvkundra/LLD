package com.vmware.ensemble.rules.i18n.enums;

import java.util.HashMap;
import java.util.Map;

public enum LoggerLevel {

    FATAL("FATAL", 5),
    ERROR("ERROR", 4),
    WARN("WARN", 3),
    INFO("INFO", 2),
    DEBUG("DEBUG", 1);

    private final String level;
    private final int levelNumber;

    private static final Map<String, LoggerLevel> LEVEL_MAP = new HashMap<>();

    static {
        for (LoggerLevel loggerLevel : LoggerLevel.values()) {
            LEVEL_MAP.put(loggerLevel.getLevel(), loggerLevel);
        }
    }

    LoggerLevel(String level, int levelNumber) {
        this.level  = level;
        this.levelNumber = levelNumber;
    }

    public String getLevel() {
        return level;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public static LoggerLevel getLevelByName(String levelName) {
        return LEVEL_MAP.get(levelName);
    }
}
