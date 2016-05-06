package org.soa.java2php;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import org.soa.java2php.body.JavaBody;
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

  private JavaBody javaBody;

  /**
   * 构造函数.
   */
  public J2pParser(final String sourcePath) {
    FileInputStream in = null;

    CompilationUnit cu = null;

    try {
      in = new FileInputStream(sourcePath);
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
    new EnumParser().visit(cu, null);
    new ClassOrInterfaceParser().visit(cu, null);
  }

  /**
   * 枚举类型Parser.
   */
  class EnumParser extends VoidVisitorAdapter {

    @Override
    public void visit(final EnumConstantDeclaration dec, final Object arg) {
      log.info(dec.getName());
      super.visit(dec, arg);
    }

    @Override
    public void visit(final EnumDeclaration dec, final Object arg) {
      log.info(dec.getName());
      super.visit(dec, arg);
    }
  }

  class ClassOrInterfaceParser extends VoidVisitorAdapter {
    @Override
    public void visit(final ClassOrInterfaceDeclaration dec, final Object arg) {
      log.info(dec.getName());
      super.visit(dec, arg);
    }
  }
}
