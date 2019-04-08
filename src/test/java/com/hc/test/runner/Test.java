package com.hc.test.runner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hc.test.runner.creator.ObjectSource;
import com.hc.test.runner.serialize.JsonSerialize;
import org.junit.Assert;
import org.junit.Before;

public class Test {
    private String json;
    @Before
    public void setUp() throws JsonProcessingException {
        TestParam param = new TestParam();
        ConstructParam constructParam = new ConstructParam();
        constructParam.setSource(ObjectSource.REFLECT);
        constructParam.setClassName("com.hc.test.runner.TestObject");


        MethodParam methodParam = new MethodParam();
        methodParam.setMethodName("search");

        ConstructParam mcp = new ConstructParam();
        mcp.setClassName("com.hc.test.runner.ConstructParam");
        mcp.setSource(ObjectSource.BASIC);
        ValueWapper wapper = new ValueWapper();
        wapper.setValue("A");
        mcp.setParam(new ValueWapper[]{wapper});
        methodParam.setParams(new ConstructParam[]{mcp});

        param.setConstructParam(constructParam);
        param.setMethodParam(methodParam);
        this.json = new ObjectMapper().writeValueAsString(param);
    }

    @org.junit.Test
    public void testTestApi() throws Exception {
        Assert.assertEquals("A",new TestApi(new JsonSerialize<>(TestParam.class)).test(json));
    }
}
