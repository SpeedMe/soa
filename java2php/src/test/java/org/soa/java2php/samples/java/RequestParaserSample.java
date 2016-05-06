package org.soa.java2php.samples.java;


import org.soa.dto.BaseRequest;

import java.util.List;

/**
 * 基础请求实体样例.
 *
 * @author: HuangLei
 * @date: 2016-05-05 8:13 PM
 */
public class RequestParaserSample extends BaseRequest {
  private String hello;
  private List<Integer> worlds;

  public String getHello() {
    return hello;
  }

  public void setHello(String hello) {
    this.hello = hello;
  }

  public List<Integer> getWorlds() {
    return worlds;
  }

  public void setWorlds(List<Integer> worlds) {
    this.worlds = worlds;
  }
}
