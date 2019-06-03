package com.hc.test.runner;

import com.hc.test.runner.serialize.ISerialize;
import org.springframework.context.ApplicationContext;

/**
 * 入口，传入String格式参数
 */
public class TestApi {
    private TestRunner testRunner;
    private ISerialize<TestParam> serialize;

    public TestApi(ISerialize<TestParam> serialize,ApplicationContext context) {
        this.serialize = serialize;
        this.testRunner = new TestRunner(context);
    }

    public Object test(String param) throws Exception {
        TestParam testParam = serialize.deSerialize(param);
        return testRunner.test(testParam);
    }
}
