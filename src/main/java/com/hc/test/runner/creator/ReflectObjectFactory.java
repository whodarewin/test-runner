package com.hc.test.runner.creator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.hc.test.runner.ConstructParam;
import com.hc.test.runner.ValueWapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ReflectObjectFactory<T> implements IObjectCreator<T,ConstructParam> {

    private DefaultObjectCreator defaultObjectFactory;
    private ObjectMapper mapper = new ObjectMapper();

    public ReflectObjectFactory(DefaultObjectCreator defaultObjectFactory) {
        this.defaultObjectFactory = defaultObjectFactory;
    }

    @Override
    public T create(ConstructParam param) throws Exception {
        String className = param.getClassName();
        Preconditions.checkNotNull(className,"reflect creator require class name");

        ValueWapper[] vw = param.getParam();
        List mp = new ArrayList();
        //todo:传null怎么办
        List<Class> argType = new ArrayList();

        if(vw != null){
            for(ValueWapper o : vw){
                Object p = getParam(o);
                if(p == null){
                    argType.add(null);
                }else {
                    argType.add(p.getClass());
                }
                mp.add(p);
            }
        }
        return create(className,argType,mp);
    }

    private T create(String className, List<Class> argType, List mp) throws Exception {
        Class clazz = Class.forName(className);
        Constructor[] constructors = clazz.getConstructors();
        Constructor needed = null;
        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];
            Class[] paramTypes = constructor.getParameterTypes();
            if(paramTypes.length != argType.size()){
                continue;
            }
            for (int m = 0; m < argType.size(); m++) {
                if(argType.get(i) != null){
                   if(argType.get(i) != paramTypes[i]){
                       continue;
                   }
                }
            }
            needed = constructor;
        }
        if(needed != null) {
            return (T)needed.newInstance(mp.toArray());
        }
        throw new NoConstructorFoundException();
    }

    private Object getParam(ValueWapper wapper) throws Exception {
        if(wapper == null){
            return null;
        }
        if(wapper.isConstructParam()){
            ConstructParam param = mapper.convertValue(wapper,ConstructParam.class);
            return defaultObjectFactory.create(param);
        }else{
            return wapper.getValue();
        }
    }
}
