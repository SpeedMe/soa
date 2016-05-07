package org.soa.java2php.samples.java;

/**
 * 枚举样例.
 *
 * @author: HuangLei
 * @date: 2016-05-05 8:12 PM
 */
public enum EnumParaserSample {
  /**
   * hello
   */
  HELLO("1", "hello"),
  /**
   * world
   */
  WORLD("2", "world");

  private String code;
  private String descrption;

  EnumParaserSample(String code, String description) {
    this.code = code;
    this.descrption = description;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescrption() {
    return descrption;
  }

  public void setDescrption(String descrption) {
    this.descrption = descrption;
  }
}
