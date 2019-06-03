package com.hc.test.runner.creator;

import com.hc.test.runner.*;
import org.springframework.context.ApplicationContext;

/**
 * 所有创建器的管理器
 * @param <T>
 */
public class DefaultObjectCreator<T> implements IObjectCreator<T,ConstructParam> {
    private BasicObjectCreator basicObjectFactory = new BasicObjectCreator();
    private ReflectObjectFactory reflectObjectFactory = new ReflectObjectFactory(this);
    private SpringObjectFactory springObjectFactory ;

    public DefaultObjectCreator(ApplicationContext context){
        this.springObjectFactory = new SpringObjectFactory(context);
    }

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
