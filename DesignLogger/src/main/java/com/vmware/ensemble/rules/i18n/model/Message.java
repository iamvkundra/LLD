package com.vmware.ensemble.rules.i18n.model;

import java.time.LocalDateTime;

import com.vmware.ensemble.rules.i18n.enums.LoggerLevel;

public class Message {

    String message;
    LocalDateTime epoch;
    LoggerLevel loggerLevel;

    public Message(String message, LoggerLevel level, LocalDateTime epoch) {
        this.message = message;
        this.loggerLevel = level;
        this.epoch = epoch;
    }

    public String getMessage(){
        return this.message;
    }

    public LocalDateTime getEpoch() {
        return this.epoch;
    }

    public LoggerLevel getLoggerLevel() {
        return this.loggerLevel;
    }
}
