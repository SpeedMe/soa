package org.soa.log;

/**
 * 日志工厂类.
 *
 * @author: HuangLei
 * @date: 2016-05-06 4:19 PM
 */
public class LoggerFactory {
  private static final boolean hasSlf4j = LogDetector.hasSlf4j();

  /**
   * 获取日志类.
   *
   * @param clazz class文件
   * @return 日志接口
   */
  public static Logger getLogger(Class<?> clazz) {
    if (hasSlf4j) {
      return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(clazz));
    }
    return new SimpleLogger(clazz);
  }
}
