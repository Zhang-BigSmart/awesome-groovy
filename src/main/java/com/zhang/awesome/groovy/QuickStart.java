package com.zhang.awesome.groovy;

import groovy.lang.*;

import java.io.File;

/**
 * @author : edison
 * 快速入门
 */
public class QuickStart {

    public static void main(String[] args) throws Exception {
        String filePath = "src/main/java/com/zhang/awesome/groovy/Hello.groovy";
        File groovyFile = new File(filePath);

        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        // 加载class
        Class groovyClass = groovyClassLoader.parseClass(groovyFile);
        // 生成实例
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
        // 反射调用say方法
        Object result = groovyObject.invokeMethod("say", "Hello");
        System.out.println("return: " + result.toString());
    }
}
