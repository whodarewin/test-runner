package com.hc.test.runner.exec;

import java.lang.reflect.InvocationTargetException;

/**
 * 方法执行器
 */
public interface IMethodExec {
    /**
     * 执行方法
     * @param param
     */
    Object exec(ExecParam param) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
