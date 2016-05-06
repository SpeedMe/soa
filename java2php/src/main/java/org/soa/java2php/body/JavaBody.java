package org.soa.java2php.body;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * JavaBody.
 *
 * @author: HuangLei
 * @date: 2016-05-06 11:13 AM
 */
public class JavaBody {
  //包名
  public String packageName;

  //是否为接口
  public boolean isInterfazz;

  //是否Enum
  public boolean isEnum;

  //类名
  public String className;

  //类注释
  public String comments;

  //引入类
  public Set<String> imports = Sets.newConcurrentHashSet();

  //依赖DTO类型
  public Set<String> depDtos = Sets.newConcurrentHashSet();

  //父类
  public List<String> parents = Lists.newArrayList();

  //接口
  public Set<String> interfazzs = Sets.newConcurrentHashSet();

  //字段列表
  //    public List<Field> fields = Lists.newArrayList();

  //方法列表
  //    public List<Method> methods = Lists.newArrayList();
}
