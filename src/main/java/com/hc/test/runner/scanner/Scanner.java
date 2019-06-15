package com.hc.test.runner.scanner;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.util.*;


/**
 * 扫描某一个包下的所有类
 * Created by congcong.han on 2019/6/7.
 */
public class Scanner {
    public Set<String> scanAllClasses(String packageName){
        Reflections reflections = new Reflections(packageName,new SubTypesScanner(false));
        Set<String> classes = reflections.getAllTypes();
        return classes;
    }

    public Set<MethodInfo> scanAllMethods(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        Method[] methods = clazz.getDeclaredMethods();
        Set<MethodInfo> methodInfos = new LinkedHashSet<>();
        for (Method method : methods) {
            MethodInfo info = new MethodInfo();
            String name = method.getName();
            Class[] clazzes = method.getParameterTypes();
            List<String> paramTypes = new ArrayList<>();
            for (Class clz : clazzes) {
                paramTypes.add(clz.getName());
            }
            info.setName(name);
            info.setParamTypes(paramTypes);
            methodInfos.add(info);
        }
        return methodInfos;
    }
}
