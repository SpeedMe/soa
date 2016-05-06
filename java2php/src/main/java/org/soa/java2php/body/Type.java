package org.soa.java2php.body;

/**
 * JavaBody 类型(类,接口,枚举).
 *
 * @author: HuangLei
 * @date: 2016-05-06 3:19 PM
 */
public enum Type {
  CLASS(1, "class"),
  INTERFACE(2, "interface"),
  ENUM(3, "enum");

  private int code;
  private String description;

  Type(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
