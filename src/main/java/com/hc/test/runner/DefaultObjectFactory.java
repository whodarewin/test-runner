package com.hc.test.runner;

public class DefaultObjectFactory<T> implements IObjectFactory<T,ConstructParam> {
    private BasicObjectFactory basicObjectFactory = new BasicObjectFactory();
    private ReflectObjectFactory reflectObjectFactory = new ReflectObjectFactory(this);
    private SpringObjectFactory springObjectFactory = new SpringObjectFactory();

    @Override
    public T create(ConstructParam param) throws NoFactoryDefinedForSource {
        switch (param.getSource()){
            case BASIC:
                return (T)basicObjectFactory.create(param);
            case REFLECT:
                return (T)reflectObjectFactory.create(param);
            case SPRING:
                return (T)springObjectFactory.create(param);
            default:
                throw new NoFactoryDefinedForSource();
        }
    }
}
