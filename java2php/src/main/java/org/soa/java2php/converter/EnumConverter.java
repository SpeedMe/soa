package org.soa.java2php.converter;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import org.apache.velocity.VelocityContext;
import org.soa.java2php.body.JavaBody;

import java.util.List;

/**
 * 枚举类型代码转换器.
 *
 * @author: HuangLei
 * @date: 2016-05-07 11:37 AM
 */
public class EnumConverter extends CodeConverter {
  public EnumConverter(JavaBody jb) {
    super(jb);
  }

  @Override
  public void convertEnumConstant(List<EnumConstantDeclaration> dec) {
    vc.put("enumConstants", dec);
  }

  @Override
  public void convertEnum(EnumDeclaration dec) {
    vc.put("enum", dec);
  }

  @Override
  public void convertClassOrInterface(ClassOrInterfaceDeclaration dec) {
    vc.put("classOrInterface", dec);
  }

  @Override
  public void convertField(List<FieldDeclaration> dec) {
    vc.put("fields", dec);
  }

  @Override
  public void convertMethod(List<MethodDeclaration> dec) {
    vc.put("methods", dec);
  }

}
