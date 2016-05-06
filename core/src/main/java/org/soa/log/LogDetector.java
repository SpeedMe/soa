package org.soa.log;

/**
 * 日志装饰类.
 *
 * @author: HuangLei
 * @date: 2016-05-06 4:26 PM
 */
public class LogDetector {
  private static final String SLF4_CLASS_NAME = "org.slf4j.Logger";

  public static boolean hasLog(String logClassName) {
    try {
      Class.forName(logClassName);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }

  /**
   * 是否存在sl4j日志.
   *
   * @return 存在返回true
   */
  public static boolean hasSlf4j() {
    return hasLog(SLF4_CLASS_NAME);
  }
}
