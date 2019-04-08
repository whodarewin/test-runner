package com.hc.test.runner.creator;


import com.hc.test.runner.ConstructParam;

public interface IObjectCreator<T,P extends ConstructParam> {

    T create(P param) throws Exception;

}
