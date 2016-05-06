package org.soa.java2php.template;

/**
 * 模板文件类型.
 *
 * @author: HuangLei
 * @date: 2016-05-07 1:54 AM
 */
public enum TemplateType {
  BASE_REQUEST("/template/php/BaseRequest.vm"),
  BASE_RESULT("/template/php/BaseResult.vm"),
  DTO("/template/php/Dto.vm"),
  ENUM("/template/php/Enum.vm"),
  INTERFACE("/template/php/Interface.vm");

  private String path;

  TemplateType(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
