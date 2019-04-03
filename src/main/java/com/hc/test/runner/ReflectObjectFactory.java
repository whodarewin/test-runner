package com.hc.test.runner;

import java.util.ArrayList;
import java.util.List;

public class ReflectObjectFactory<T> implements IObjectFactory<T,ConstructParam> {

    private DefaultObjectFactory defaultObjectFactory;

    public ReflectObjectFactory(DefaultObjectFactory defaultObjectFactory) {
        this.defaultObjectFactory = defaultObjectFactory;
    }

    @Override
    public T create(ConstructParam param) throws Exception {
        String className = param.getClassName();
        Object cp = param.getParam();
        List mp = new ArrayList();
        //todo:传null怎么办
        List<Class> argType = new ArrayList();
        if(cp != null){
            if(cp.getClass().isArray()){
                for(Object o : (Object[])cp){
                    Object p = getParam(o);
                    argType.add(p.getClass());
                    mp.add(p);
                }
            }else{
                mp.add(getParam(cp));
            }
        }
        return (T)Class.forName(className).getConstructor(argType.toArray(new Class[0])).newInstance(mp.toArray());
    }

    private Object getParam(Object o) throws NoFactoryDefinedForSource {
        if(o instanceof ConstructParam){
            return defaultObjectFactory.create((ConstructParam) o);
        }else{
            return o;
        }
    }
}
