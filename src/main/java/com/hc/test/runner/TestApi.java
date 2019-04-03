package com.hc.test.runner;

import java.io.IOException;

/**
 * 入口，传入String格式参数
 */
public class TestApi {
    private TestRunner testRunner = new TestRunner();
    private ISerialize<TestParam> serialize;

    public TestApi(ISerialize<TestParam> serialize) {
        this.serialize = serialize;
    }

    public Object test(String param) throws IOException {
        TestParam testParam = serialize.deSerialize(param);
        return (Object) testRunner.test(testParam);
    }
}
