package org.soa.java2php;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.soa.log.Slf4jLogger;

import java.io.FileInputStream;

import static org.junit.Assert.*;

/**
 * J2pParser测试.
 *
 * @author: HuangLei
 * @date: 2016-05-06 2:50 PM
 */
public class J2pParserTest {
    @Test
    public void testEnumParser() throws Exception{
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        String enumPath = "/Users/huanglei/Projects/github/soa/java2php" +
                "/src/test/java/org/soa/java2php/samples/java/EnumParaserSample.java";

        new J2pParser(enumPath);
    }
}