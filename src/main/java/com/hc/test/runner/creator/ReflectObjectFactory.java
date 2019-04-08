package com.hc.test.runner.creator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hc.test.runner.ConstructParam;
import com.hc.test.runner.ValueWapper;

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
        ValueWapper[] vw = param.getParam();
        List mp = new ArrayList();
        //todo:传null怎么办
        List<Class> argType = new ArrayList();
        if(vw != null){
            for(ValueWapper o : vw){
                Object p = getParam(o);
                argType.add(p.getClass());
                mp.add(p);
            }
        }
        return (T)Class.forName(className).getConstructor(argType.toArray(new Class[0])).newInstance(mp.toArray());
    }

    private Object getParam(ValueWapper o) throws Exception {
        if(o.isConstructParam()){
            ConstructParam param = mapper.convertValue(o,ConstructParam.class);
            return defaultObjectFactory.create(param);
        }else{
            return o.getValue();
        }
    }
}
