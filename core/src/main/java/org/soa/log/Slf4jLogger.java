package org.soa.log;

import org.apache.log4j.PropertyConfigurator;

/**
 * sl4j日志类.
 *
 * @author: HuangLei
 * @date: 2016-05-06 4:19 PM
 */
public class Slf4jLogger implements Logger {
  private final org.slf4j.Logger logger;

  static {
    PropertyConfigurator.configure(Slf4jLogger.class.getResource("").getPath() + "config/log4j.properties");
  }

  public Slf4jLogger(org.slf4j.Logger logger) {
    this.logger = logger;
  }

  @Override
  public void debug(String msg) {
    logger.debug(msg);
  }

  @Override
  public void debug(String msg, Object... args) {
    logger.debug(msg, args);
  }

  @Override
  public void info(String msg) {
    logger.info(msg);
  }

  @Override
  public void info(String msg, Object... args) {
    logger.info(msg, args);
  }

  @Override
  public void warn(String msg) {
    logger.warn(msg);
  }

  @Override
  public void warn(String msg, Object... args) {
    logger.warn(msg, args);
  }

  @Override
  public void warn(String msg, Throwable exception) {
    logger.warn(msg, exception);
  }

  @Override
  public void error(String msg) {
    logger.error(msg);
  }

  @Override
  public void error(String msg, Object... args) {
    logger.error(msg, args);
  }

  @Override
  public void error(String msg, Throwable th) {
    logger.error(msg, th);
  }
}
