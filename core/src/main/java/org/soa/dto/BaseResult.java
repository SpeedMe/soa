package org.soa.dto;

import java.io.Serializable;

/**
 * 响应基础实体类.
 *
 * @author: HuangLei
 * @date: 2016-05-05 8:24 PM
 */
public class BaseResult implements Serializable {

  private static final long serialVersionUID = 3624367990866706188L;

  /**
   * 请求流水号.
   */
  private String sid;

  /**
   * 接口是否成功.
   */
  private boolean success;

  /**
   * 响应码.
   */
  private String code;

  /**
   * 响应描述.
   */
  private String message;

  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
