package org.soa.java2php.samples.java;

/**
 * 接口样例.
 *
 * @author: HuangLei
 * @date: 2016-05-05 8:11 PM
 */
public interface InterfaceParaserSample {
  /**
   * 获取 hello.
   *
   * @param code        代码
   * @param description 描述
   * @return 字符串
   */
  String getHello(final Integer code, final Integer description);

  /**
   * 获取world.
   *
   * @param msg 消息
   * @return 是否正确
   */
  Boolean getWorld(String msg);
}
