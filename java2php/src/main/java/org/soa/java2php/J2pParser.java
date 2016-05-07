package org.soa.java2php;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import org.soa.java2php.body.JavaBody;
import org.soa.java2php.template.VelocityTemplate;
import org.soa.log.Logger;
import org.soa.log.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * J2pParser 启动器.
 *
 * @author: HuangLei
 * @date: 2016-05-06 11:07 AM
 */
public class J2pParser {
  private Logger log = LoggerFactory.getLogger(J2pParser.class);

  private JavaBody jb;
  private CompilationUnit cu;

  /**
   * 构造函数.
   */
  public J2pParser(final String sourcePath) {
    cu = getCompilationUnit(sourcePath);
    jb = new JavaBody();

    new PackageVisitor().visit(cu, null);
    new ImportVisitor().visit(cu, null);
    new EnumVisitor().visit(cu, null);
    new ClassOrInterfaceVisitor().visit(cu, null);
    new FieldVisitor().visit(cu, null);
    new MethodVisitor().visit(cu, null);
  }

  /**
   * 解析成php代码.
   */
  public void parse2php(final String toPath) throws IOException {
    new VelocityTemplate(jb).writeFile(toPath);
  }

  /**
   * 获取CompilationUnit.
   *
   * @param path java文件路径
   * @return CompilationUnit
   */
  private CompilationUnit getCompilationUnit(final String path) {
    FileInputStream in = null;

    CompilationUnit cu = null;

    try {
      in = new FileInputStream(path);
      cu = JavaParser.parse(in);
    } catch (ParseException parseEx) {
      log.error("ParseException error:", parseEx);
    } catch (FileNotFoundException fileEx) {
      log.error("FileNotFoundException error:", fileEx);
    } finally {
      try {
        in.close();
      } catch (IOException ex) {
        log.error("close FileInputStream failed:", ex);
      }
    }

    return cu;
  }


  /**
   * 包 Visitor.
   */
  class PackageVisitor extends VoidVisitorAdapter {
    @Override
    public void visit(final PackageDeclaration dec, final Object arg) {
      jb.setPackageDec(dec);

      super.visit(dec, arg);
    }
  }

  /**
   * Import Visitor.
   */
  class ImportVisitor extends VoidVisitorAdapter {
    @Override
    public void visit(ImportDeclaration dec, Object arg) {
      jb.getImports().add(dec);
      super.visit(dec, arg);
    }
  }

  /**
   * 枚举类型Visitor.
   */
  class EnumVisitor extends VoidVisitorAdapter {

    @Override
    public void visit(final EnumConstantDeclaration dec, final Object arg) {
      jb.setEnum(true);
      jb.getEnumConstants().add(dec);

      super.visit(dec, arg);
    }

    @Override
    public void visit(final EnumDeclaration dec, final Object arg) {
      jb.setEnum(true);
      jb.setEnumDec(dec);

      super.visit(dec, arg);
    }
  }

  /**
   * 类和接口Visitor.
   */
  class ClassOrInterfaceVisitor extends VoidVisitorAdapter {
    @Override
    public void visit(final ClassOrInterfaceDeclaration dec, final Object arg) {
      jb.setInterface(dec.isInterface());
      jb.setClassOrInterfaceDec(dec);

      super.visit(dec, arg);
    }
  }

  /**
   * 字段Visitor.
   */
  class FieldVisitor extends VoidVisitorAdapter {
    @Override
    public void visit(final FieldDeclaration dec, final Object arg) {
      jb.getFields().add(dec);

      super.visit(dec, arg);
    }
  }

  /**
   * 方法Visitor.
   */
  class MethodVisitor extends VoidVisitorAdapter {
    @Override
    public void visit(final MethodDeclaration dec, final Object arg) {
      jb.getMethods().add(dec);

      super.visit(dec, arg);
    }
  }
}
