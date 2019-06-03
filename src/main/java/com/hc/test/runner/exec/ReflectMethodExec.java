package com.hc.test.runner.exec;


import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

/**
 * 使用反射机制执行
 */
public class ReflectMethodExec implements IMethodExec {

    @Override
    public Object exec(ExecParam param) {
        Class[] argTypes = null;
        try {
            Object instant = param.getOrigin();
            String methodName = param.getMethodName();
            Object[] args = param.getParams();
            argTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argTypes[i] = args[i].getClass();
            }

            return instant.getClass().getMethod(methodName, argTypes).invoke(instant, args);
        }catch (NoSuchMethodException e){
            return "class " + param.getOrigin().getClass().getName()
                    + " have no method "+ param.getMethodName()
                    + " with param class"
                    + " " + Stream.of(argTypes).map(a -> a.getName())
                    .reduce((a,b)-> a+b);
        }catch (IllegalAccessException e){
            return "class " + param.getOrigin().getClass().getName()
                    + " method "+ param.getMethodName()
                    + " with param class"
                    + " " + Stream.of(argTypes).map(a -> a.getName())
                    .reduce((a,b)-> a+b)
                    + "can not access from outside";
        }catch(InvocationTargetException e){
            return e;
        }
    }
}
