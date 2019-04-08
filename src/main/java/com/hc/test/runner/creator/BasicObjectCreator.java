package com.hc.test.runner.creator;

import com.hc.test.runner.ConstructParam;

public class BasicObjectCreator<T> implements IObjectCreator<T,ConstructParam> {
    @Override
    public T create(ConstructParam param) {
        if(param.getParam().length == 0 || param.getParam() == null){
            return null;
        }
        return (T)param.getParam()[0].getValue();
    }
}
