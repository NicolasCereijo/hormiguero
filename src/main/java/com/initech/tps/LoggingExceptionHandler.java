package com.initech.tps;

import java.lang.Thread.UncaughtExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExceptionHandler implements UncaughtExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExceptionHandler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        logger.error("PATATA", e);
    }
}