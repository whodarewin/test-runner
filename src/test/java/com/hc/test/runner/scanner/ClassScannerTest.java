package com.hc.test.runner.scanner;

import junit.framework.TestCase;

import java.util.Set;

/**
 * Created by congcong.han on 2019/6/7.
 */
public class ClassScannerTest extends TestCase{
    private ClassScanner classScanner = new ClassScanner();
    public void testClassScanner(){
        Set<String> classes = classScanner.scanAllClass("com.hc.test.runner.scanner");
        assertTrue(classes.contains("com.hc.test.runner.scanner.ClassScanner"));
    }
}
