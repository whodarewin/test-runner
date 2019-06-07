package com.hc.test.runner.scanner;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.Set;


/**
 * 扫描某一个包下的所有类
 * Created by congcong.han on 2019/6/7.
 */
public class ClassScanner {
    public Set<String> scanAllClass(String packageName){
        Reflections reflections = new Reflections(packageName,new SubTypesScanner(false));
        Set<String> classes = reflections.getAllTypes();
        return classes;
    }
}
