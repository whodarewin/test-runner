package com.hc.test.runner.scanner;

import junit.framework.TestCase;

import java.util.Set;

/**
 * Created by congcong.han on 2019/6/7.
 */
public class ClassScannerTest extends TestCase{

    private Scanner classScanner = new Scanner();

    public void testClassScanner() throws ClassNotFoundException {
        Set<String> classes = classScanner.scanAllClasses("com.hc.test.runner.scanner");
        assertTrue(classes.contains("com.hc.test.runner.scanner.Scanner"));
        Set<MethodInfo> infos = classScanner.scanAllMethods("com.hc.test.runner.scanner.Scanner");
        assertEquals(infos.iterator().next().getName(),"scanAllClasses");
    }
}
