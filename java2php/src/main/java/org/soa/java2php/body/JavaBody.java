package org.soa.java2php.body;

import com.google.common.collect.Lists;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.util.List;

/**
 * JavaBody.
 *
 * @author: HuangLei
 * @date: 2016-05-06 11:13 AM
 */
public class JavaBody {
  //是否为接口
  private boolean isInterface;

  //是否Enum
  private boolean isEnum;

  //enum 常量
  private List<EnumConstantDeclaration> enumConstants = Lists.newArrayList();

  //enum
  private EnumDeclaration enumDec;

  //包名
  private PackageDeclaration packageDec;

  //引入包
  private List<ImportDeclaration> imports = Lists.newArrayList();

  //接口或类实体
  private ClassOrInterfaceDeclaration classOrInterfaceDec;

  //字段
  private List<FieldDeclaration> fields = Lists.newArrayList();

  //方法
  private List<MethodDeclaration> methods = Lists.newArrayList();

  public boolean isInterface() {
    return isInterface;
  }

  public void setInterface(boolean anInterface) {
    isInterface = anInterface;
  }

  public boolean isEnum() {
    return isEnum;
  }

  public void setEnum(boolean anEnum) {
    isEnum = anEnum;
  }

  public List<EnumConstantDeclaration> getEnumConstants() {
    return enumConstants;
  }

  public void setEnumConstants(List<EnumConstantDeclaration> enumConstants) {
    this.enumConstants = enumConstants;
  }

  public EnumDeclaration getEnumDec() {
    return enumDec;
  }

  public void setEnumDec(EnumDeclaration enumDec) {
    this.enumDec = enumDec;
  }

  public PackageDeclaration getPackageDec() {
    return packageDec;
  }

  public void setPackageDec(PackageDeclaration packageDec) {
    this.packageDec = packageDec;
  }

  public List<ImportDeclaration> getImports() {
    return imports;
  }

  public void setImports(List<ImportDeclaration> imports) {
    this.imports = imports;
  }

  public ClassOrInterfaceDeclaration getClassOrInterfaceDec() {
    return classOrInterfaceDec;
  }

  public void setClassOrInterfaceDec(ClassOrInterfaceDeclaration classOrInterfaceDec) {
    this.classOrInterfaceDec = classOrInterfaceDec;
  }

  public List<FieldDeclaration> getFields() {
    return fields;
  }

  public void setFields(List<FieldDeclaration> fields) {
    this.fields = fields;
  }

  public List<MethodDeclaration> getMethods() {
    return methods;
  }

  public void setMethods(List<MethodDeclaration> methods) {
    this.methods = methods;
  }
}
