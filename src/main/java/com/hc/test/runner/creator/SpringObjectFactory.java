package com.hc.test.runner.creator;

import com.hc.test.runner.ConstructParam;
import com.hc.test.runner.ValueWapper;
import org.springframework.context.ApplicationContext;

public class SpringObjectFactory<T> implements IObjectCreator<T,ConstructParam> {

    private ApplicationContext applicationContext;

    public SpringObjectFactory(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    @Override
    public T create(ConstructParam param) throws NoNameForSpringBeanException {
        ValueWapper[] wappers = param.getParam();
        if(wappers == null || wappers.length == 0){
            throw new NoNameForSpringBeanException("bean name is null");
        }
        Object bean =  applicationContext.getBean(wappers[0].toString());
        if(bean == null){
            throw new NoNameForSpringBeanException("bean name is " + wappers[0].toString());
        }
        return (T)bean;
    }
}
