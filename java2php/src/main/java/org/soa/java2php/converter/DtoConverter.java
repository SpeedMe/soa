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
 * Dto实体代码的转换器.
 *
 * @author: HuangLei
 * @date: 2016-05-07 11:16 AM
 */
public class DtoConverter extends CodeConverter {

  public DtoConverter(JavaBody jb) {
    super(jb);
  }

  @Override
  void convertClassOrInterface(ClassOrInterfaceDeclaration dec) {

  }

  @Override
  void convertField(List<FieldDeclaration> dec) {

  }

  @Override
  void convertMethod(List<MethodDeclaration> dec) {

  }
}
