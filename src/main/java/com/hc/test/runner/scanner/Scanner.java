package com.hc.test.runner.scanner;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.util.Set;


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

    public Set<String> scanAllMethods(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        Method[] methods = clazz.getDeclaredMethods();
        return null;
    }
}
