package org.soa.log;

/**
 * 日志接口.
 *
 * @author: HuangLei
 * @date: 2016-05-06 4:14 PM
 */
public interface Logger {
  void debug(String msg);

  void debug(String msg, Object... args);

  void info(String msg);

  void info(String msg, Object... args);

  void warn(String msg);

  void warn(String msg, Object... args);

  void warn(String msg, Throwable exception);

  void error(String msg);

  void error(String msg, Object... args);

  void error(String msg, Throwable th);
}
