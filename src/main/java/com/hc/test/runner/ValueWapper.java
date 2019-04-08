package com.hc.test.runner;

public class ValueWapper {
    private boolean isConstructParam;
    private Object value;

    public boolean isConstructParam() {
        return isConstructParam;
    }

    public void setConstructParam(boolean constructParam) {
        isConstructParam = constructParam;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
