package org.soa.java2php.template;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.soa.java2php.body.JavaBody;
import org.soa.java2php.converter.DtoConverter;
import org.soa.java2php.converter.EnumConverter;
import org.soa.java2php.converter.InterfaceConverter;
import org.soa.log.Logger;
import org.soa.log.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * velocity 模板.
 *
 * @author: HuangLei
 * @date: 2016-05-07 1:42 AM
 */
public class VelocityTemplate {
  private Logger log = LoggerFactory.getLogger(VelocityTemplate.class);

  private String packageName;
  private String className;

  private Template template;
  private VelocityContext ctx;

  /**
   * 构造函数.
   */
  public VelocityTemplate(JavaBody jb) {
    log.info("parser javabody:{}", jb.getMethods().get(0).getComment());

    VelocityEngine ve = init();
    packageName = jb.getPackageDec().getPackageName();
    if (jb.isEnum()) {
      template = ve.getTemplate(TemplateType.ENUM.getPath());
      ctx = new EnumConverter(jb).convert();
      className = jb.getEnumDec().getName();

    } else if (jb.isInterface()) {
      template = ve.getTemplate(TemplateType.INTERFACE.getPath());
      ctx = new InterfaceConverter(jb).convert();
      className = jb.getClassOrInterfaceDec().getName();

    } else {
      template = ve.getTemplate(TemplateType.DTO.getPath());
      ctx = new DtoConverter(jb).convert();
      className = jb.getClassOrInterfaceDec().getName();
    }
  }

  /**
   * 初始化模板引擎.
   */
  private VelocityEngine init() {
    VelocityEngine ve = new VelocityEngine();
    ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
    ve.setProperty("input.encoding", "utf-8");
    ve.setProperty("output.encoding", "utf-8");
    ve.init();
    return ve;
  }

  /**
   * 写入php文件.
   *
   * @throws IOException io异常
   */
  public void writeFile(String toPath) throws IOException {
    log.info("export path:{}", toPath);

    StringWriter sw = new StringWriter();
    template.merge(ctx, sw);

    String genFileDir = toPath + File.separator
        + StringUtils.replace(packageName, ".", File.separator)
        + File.separator;

    File genDir = new File(genFileDir);
    //删除存在目录
    genDir.deleteOnExit();
    genDir.mkdirs();

    String genFileName = genFileDir + className + ".php";
    FileWriter writer = new FileWriter(genFileName);
    writer.write(sw.toString());
    writer.close();
  }
}
