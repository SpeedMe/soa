package org.soa.java2php.body;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.util.List;
import java.util.Set;

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
  private EnumConstantDeclaration enumConstantDec;

  //enum
  private EnumDeclaration enumDec;

  //包名
  private PackageDeclaration packageDec;

  //引入包
  private ImportDeclaration importDec;

  //接口或类实体
  private ClassOrInterfaceDeclaration classOrInterfaceDec;

  //字段
  private FieldDeclaration fieldDec;

  //方法
  private MethodDeclaration methodDec;

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

  public EnumConstantDeclaration getEnumConstantDec() {
    return enumConstantDec;
  }

  public void setEnumConstantDec(EnumConstantDeclaration enumConstantDec) {
    this.enumConstantDec = enumConstantDec;
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

  public ImportDeclaration getImportDec() {
    return importDec;
  }

  public void setImportDec(ImportDeclaration importDec) {
    this.importDec = importDec;
  }

  public ClassOrInterfaceDeclaration getClassOrInterfaceDec() {
    return classOrInterfaceDec;
  }

  public void setClassOrInterfaceDec(ClassOrInterfaceDeclaration classOrInterfaceDec) {
    this.classOrInterfaceDec = classOrInterfaceDec;
  }

  public FieldDeclaration getFieldDec() {
    return fieldDec;
  }

  public void setFieldDec(FieldDeclaration fieldDec) {
    this.fieldDec = fieldDec;
  }

  public MethodDeclaration getMethodDec() {
    return methodDec;
  }

  public void setMethodDec(MethodDeclaration methodDec) {
    this.methodDec = methodDec;
  }

  @Override
  public String toString() {
    return "JavaBody{" +
        "isInterface=" + isInterface +
        ", isEnum=" + isEnum +
        ", enumConstantDec=" + enumConstantDec +
        ", enumDec=" + enumDec +
        ", packageDec=" + packageDec +
        ", importDec=" + importDec +
        ", classOrInterfaceDec=" + classOrInterfaceDec +
        ", fieldDec=" + fieldDec +
        ", methodDec=" + methodDec +
        '}';
  }
}
