package com.hc.test.runner;


import com.hc.test.runner.creator.DefaultObjectCreator;
import com.hc.test.runner.exec.ExecParam;
import com.hc.test.runner.exec.IMethodExec;
import com.hc.test.runner.exec.ReflectMethodExec;
import org.springframework.context.ApplicationContext;


/**
 * TestRunner
 * 测试运行组件
 * @author han.congcong
 * @date 2019/6/3
 */

public class TestRunner {

    private DefaultObjectCreator defaultObjectCreator;
    private IMethodExec methodExec = new ReflectMethodExec();
    public TestRunner(ApplicationContext context){
        this.defaultObjectCreator = new DefaultObjectCreator(context);
    }

    public Object test(TestParam param) throws Exception {
        ConstructParam constructParam = param.getConstructParam();
        MethodParam methodParam = param.getMethodParam();
        ConstructParam[] methodConstructParam = methodParam.getParams();

        Object instance = defaultObjectCreator.create(constructParam);
        Object[] methodParams = new Object[methodConstructParam.length];
        for (int i = 0; i < methodConstructParam.length; i++) {
            methodParams[i] = defaultObjectCreator.create(methodConstructParam[i]);
        }
        ExecParam execParam = new ExecParam();
        execParam.setMethodName(methodParam.getMethodName());
        execParam.setOrigin(instance);
        execParam.setParams(methodParams);
        return methodExec.exec(execParam);
    }
}
