package org.soa.log;

/**
 * 日志装饰类.
 *
 * @author: HuangLei
 * @date: 2016-05-06 4:26 PM
 */
public class LogDetector {
  private static final String SLF4_CLASS_NAME = "org.slf4j.Logger";

  /**
   * 是否存在此日志框架.
   */
  public static boolean hasLog(String logClassName) {
    try {
      Class.forName(logClassName);
      return true;
    } catch (ClassNotFoundException ex) {
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
