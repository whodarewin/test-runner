package com.hc.test.runner;

public class ReflectConstructParam extends ConstructParam{
    /**
     * 反射创建需要的构造器参数
     */
    private ConstructParam[] param;

    public ConstructParam[] getParam() {
        return param;
    }

    public void setParam(ConstructParam[] param) {
        this.param = param;
    }
}
