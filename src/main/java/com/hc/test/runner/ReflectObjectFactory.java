package com.hc.test.runner;

public class ReflectObjectFactory<T> implements IObjectFactory<T,ReflectConstructParam> {

    private DefaultObjectFactory defaultObjectFactory;

    public ReflectObjectFactory(DefaultObjectFactory defaultObjectFactory) {
        this.defaultObjectFactory = defaultObjectFactory;
    }

    @Override
    public T create(ReflectConstructParam param) {
        return null;
    }
}
