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
 * 接口类型代码转换器.
 *
 * @author: HuangLei
 * @date: 2016-05-07 11:33 AM
 */
public class InterfaceConverter extends CodeConverter {

  public InterfaceConverter(final JavaBody jb) {
    super(jb);
  }

  @Override
  public void convertClassOrInterface(ClassOrInterfaceDeclaration dec) {

  }

  @Override
  public void convertField(List<FieldDeclaration> dec) {

  }

  @Override
  public void convertMethod(List<MethodDeclaration> dec) {

  }
}
