package com.hc.test.runner;

import com.hc.test.runner.serialize.ISerialize;

/**
 * 入口，传入String格式参数
 */
public class TestApi {
    private TestRunner testRunner = new TestRunner();
    private ISerialize<TestParam> serialize;

    public TestApi(ISerialize<TestParam> serialize) {
        this.serialize = serialize;
    }

    public Object test(String param) throws Exception {
        TestParam testParam = serialize.deSerialize(param);
        return testRunner.test(testParam);
    }
}
