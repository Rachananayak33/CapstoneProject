package com.log4j.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Logtest {
static Logger logger=Logger.getLogger(Logtest.class);
public static void main(String[] args) {

BasicConfigurator.configure();
logger.debug("Debugging you know..");
}
}
