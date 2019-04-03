package com.hc.test.runner;

/**
 * 构造一个bean需要的参数
 */
public class ConstructParam {
    /**
     * 类的名字
     */
    private String className;
    /**
     * 类应该从哪里创建
     */
    private ObjectSource source;

    /**
     * 类创建需要的参数
     */
    private Object param;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ObjectSource getSource() {
        return source;
    }

    public void setSource(ObjectSource source) {
        this.source = source;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }
}
