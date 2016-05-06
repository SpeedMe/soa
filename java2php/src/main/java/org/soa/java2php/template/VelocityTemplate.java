package org.soa.java2php.template;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.soa.java2php.body.JavaBody;
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

  private String toPath;
  private String packageName;
  private String className;

  /**
   * 构造函数.
   */
  public VelocityTemplate(JavaBody jb, TemplateType type) {
    VelocityEngine ve = init();
    Template template = ve.getTemplate(type.getPath());
    VelocityContext ctx = new VelocityContext();

    //TODO 此处开始
    ctx.put("namespace", "");

    try {
      writeFile(template, ctx);
    } catch (IOException ex) {
      log.error("写入velocity模板失败:", ex);
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
   * @param template 模板
   * @param ctx      velocity内容
   * @throws IOException io异常
   */
  private void writeFile(Template template, VelocityContext ctx) throws IOException {
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
