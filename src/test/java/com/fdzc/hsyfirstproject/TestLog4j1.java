package com.fdzc.hsyfirstproject;

import org.apache.log4j.Logger;

public class TestLog4j1 {
    private static final Logger logger = Logger.getLogger(TestLog4j.class);
    public static void main(String[] args) {
        logger.debug("This is a debug log.");
        logger.info("This is an info log.");
        logger.warn("This is a warn log.");
        logger.error("This is an error log.");
        logger.fatal("This is a fatal log.");
    }
}