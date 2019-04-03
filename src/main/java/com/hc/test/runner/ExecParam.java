package com.hc.test.runner;

/**
 * 执行方法需要的参数
 */
public class ExecParam {
    private Object origin;
    private String methodName;
    private Object[] params;

    public Object getOrigin() {
        return origin;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
