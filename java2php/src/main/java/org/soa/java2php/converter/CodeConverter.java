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

import java.util.Date;
import java.util.List;

/**
 * 代码转换器接口.
 *
 * @author: HuangLei
 * @date: 2016-05-07 10:58 AM
 */
public abstract class CodeConverter {
  private JavaBody jb;
  protected VelocityContext vc;

  /**
   * 构造器.
   */
  public CodeConverter(JavaBody jb) {
    this.jb = jb;
    vc = new VelocityContext();

    vc.put("date", new Date());
  }

  /**
   * 集体转换.
   */
  public VelocityContext convert() {
    convertPackage(jb.getPackageDec());
    convertImport(jb.getImports());
    convertClassOrInterface(jb.getClassOrInterfaceDec());
    convertEnum(jb.getEnumDec());
    convertEnumConstant(jb.getEnumConstants());
    convertField(jb.getFields());
    convertMethod(jb.getMethods());

    return vc;
  }

  /**
   * 包名.
   */
  void convertPackage(final PackageDeclaration dec) {
    vc.put("namespace", dec);
  }

  /**
   * 导入包名.
   */
  void convertImport(final List<ImportDeclaration> dec) {
    vc.put("uses", dec);
  }

  /**
   * 枚举常量.
   */
  void convertEnumConstant(final List<EnumConstantDeclaration> dec) {
  }

  /**
   * 枚举.
   */
  void convertEnum(final EnumDeclaration dec) {
  }

  /**
   * 类或接口.
   */
  abstract void convertClassOrInterface(final ClassOrInterfaceDeclaration dec);

  /**
   * 字段.
   */
  abstract void convertField(final List<FieldDeclaration> dec);

  /**
   * 方法.
   */
  abstract void convertMethod(final List<MethodDeclaration> dec);
}
