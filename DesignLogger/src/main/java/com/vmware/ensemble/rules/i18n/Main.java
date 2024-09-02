package com.vmware.ensemble.rules.i18n;

import static com.vmware.ensemble.rules.i18n.constants.LoggerConstants.CONSOLE;
import static com.vmware.ensemble.rules.i18n.constants.LoggerConstants.DATABASE;
import static com.vmware.ensemble.rules.i18n.constants.LoggerConstants.FILE;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.LoggerLevel;
import com.vmware.ensemble.rules.i18n.enums.LoggerType;
import com.vmware.ensemble.rules.i18n.service.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------LOGGER---------------------------------------------");
        int bufferSize = 15;

        Logger logger = Logger.getLogger();
        logger.setLoggerLevel(LoggerLevel.ERROR); //Global logging level set.

        logger.setBufferSize(15);

        List<String> fatalSinkType = new ArrayList<>();
        fatalSinkType.add(DATABASE);
        fatalSinkType.add(CONSOLE);
        logger.addLoggerConfig("FATAL", LoggerType.SYNC, fatalSinkType);


        List<String> errorSinkType = new ArrayList<>();
        errorSinkType.add(FILE);
        errorSinkType.add(CONSOLE);
        logger.addLoggerConfig("ERROR", LoggerType.SYNC, errorSinkType);

        List<String> warnSinkType = new ArrayList<>();
        warnSinkType.add(CONSOLE);
        logger.addLoggerConfig("WARN", LoggerType.SYNC, warnSinkType);

        List<String> infoSinkType = new ArrayList<>();
        infoSinkType.add(CONSOLE);
        logger.addLoggerConfig("INFO", LoggerType.SYNC, infoSinkType);

        List<String> debugSinkType = new ArrayList<>();
        debugSinkType.add(CONSOLE);
        logger.addLoggerConfig("DEBUG", LoggerType.SYNC, debugSinkType);

        logger.log("This is a log message", "ERROR", LocalDateTime.now());


    }
}