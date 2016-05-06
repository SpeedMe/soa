package org.soa.dto;

import java.io.Serializable;

/**
 * 基础请求实体.
 *
 * @author: HuangLei
 * @date: 2016-05-05 8:23 PM
 */
public class BaseRequest implements Serializable {
  private static final long serialVersionUID = -7317050225001117881L;

  /**
   * 请求流水号.
   */
  private String sid;

  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }
}
