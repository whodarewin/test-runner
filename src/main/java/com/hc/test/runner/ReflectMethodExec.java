package com.hc.test.runner;

import java.lang.reflect.InvocationTargetException;

/**
 * 使用反射机制执行
 */
public class ReflectMethodExec implements IMethodExec {

    @Override
    public Object exec(ExecParam param) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object instant = param.getOrigin();
        String methodNamd = param.getMethodName();
        Object[] args = param.getParams();
        Class[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }

        return instant.getClass().getMethod(methodNamd,argTypes).invoke(instant,args);
    }
}
