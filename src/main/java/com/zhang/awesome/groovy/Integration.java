package com.zhang.awesome.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;

import javax.script.*;
import java.util.Date;

/**
 * @author : edison
 */
public class Integration {

    public static void main(String[] args) throws Exception {
        groovyClassLoader();
    }

    public static void groovyShell() {
        final String script = "Runtime.getRuntime().availableProcessors()";
        Binding intBinding = new Binding();
        GroovyShell shell = new GroovyShell(intBinding);
        final Object eval = shell.evaluate(script);
        System.out.println(eval);
    }

    public static void scriptEngineManager() throws ScriptException, NoSuchMethodException {
        ScriptEngineManager factory = new ScriptEngineManager();
        // 每次生成一个engine实例
        ScriptEngine engine = factory.getEngineByName("groovy");
        Bindings binding = engine.createBindings();
        // 入参
        binding.put("date", new Date());
        // 如果script文本来自文件,请首先获取文件内容
        engine.eval("def getTime(){return date.getTime();}", binding);
        engine.eval("def sayHello(name,age){return 'Hello,I am ' + name + ',age' + age;}");
        // 反射到方法
        Long time = (Long) ((Invocable) engine).invokeFunction("getTime", null);
        System.out.println(time);
        String message = (String) ((Invocable) engine).invokeFunction("sayHello", "zhangsan", 12);
        System.out.println(message);
    }

    public static void groovyClassLoader() throws InstantiationException, IllegalAccessException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        // 可以是纯Java代码
        String helloScript = "package com.vivo.groovy.util" +
                "class Hello {" +
                "String say(String name) {" +
                "System.out.println(\"hello, \" + name)" +
                " return name;" +
        "}" +
                "}";
        Class helloClass = groovyClassLoader.parseClass(helloScript);
        GroovyObject object = (GroovyObject) helloClass.newInstance();
        // 控制台输出"hello, vivo"
        Object ret = object.invokeMethod("say", "vivo");
        // 打印vivo
        System.out.println(ret.toString());
    }

}
