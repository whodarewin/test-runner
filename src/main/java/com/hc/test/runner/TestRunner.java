package com.hc.test.runner;



public class TestRunner {
    private DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
    private IMethodExec methodExec = new ReflectMethodExec();
    public Object test(TestParam param) throws NoFactoryDefinedForSource {
        ConstructParam constructParam = param.getConstructParam();
        MethodParam methodParam = param.getMethodParam();
        ConstructParam[] methodConstructParam = methodParam.getParams();

        Object instance = defaultObjectFactory.create(constructParam);
        Object[] methodParams = new Object[methodConstructParam.length];
        for (int i = 0; i < methodConstructParam.length; i++) {
            methodParams[i] = defaultObjectFactory.create(methodConstructParam[i]);
        }
        ExecParam execParam = new ExecParam();
        execParam.setMethodName(methodParam.getMethodName());
        execParam.setOrigin(instance);
        execParam.setParams(methodParams);
        return methodExec.exec(execParam);
    }
}
