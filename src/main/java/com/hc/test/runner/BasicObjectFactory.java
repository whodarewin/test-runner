package com.hc.test.runner;

public class BasicObjectFactory<T> implements IObjectFactory<T,ConstructParam> {
    @Override
    public T create(ConstructParam param) {
        return (T)param.getParam();
    }
}
