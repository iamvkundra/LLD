package com.vmware.ensemble.rules.i18n.api;

import java.time.LocalDateTime;

public interface ILogger {
    void log(final String message, final String level, LocalDateTime now);
}
