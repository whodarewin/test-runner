package com.hc.test.runner.creator;

import com.hc.test.runner.*;

public class DefaultObjectCreator<T> implements IObjectCreator<T,ConstructParam> {
    private BasicObjectCreator basicObjectFactory = new BasicObjectCreator();
    private ReflectObjectFactory reflectObjectFactory = new ReflectObjectFactory(this);
    private SpringObjectFactory springObjectFactory = new SpringObjectFactory();

    @Override
    public T create(ConstructParam param) throws Exception {
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
