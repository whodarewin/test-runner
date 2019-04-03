package com.hc.test.runner;

public class BasicObjectFactory<T> implements IObjectFactory<T,BasicConstructParam> {
    @Override
    public T create(BasicConstructParam param) {
        return (T)param.getBasic();
    }
}
