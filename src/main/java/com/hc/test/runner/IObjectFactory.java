package com.hc.test.runner;


public interface IObjectFactory<T,P extends ConstructParam> {

    T create(P param) throws Exception;

}
