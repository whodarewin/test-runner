package com.hc.test.runner.creator;

public class NoFactoryDefinedForSource extends Exception{
    public NoFactoryDefinedForSource() {
    }

    public NoFactoryDefinedForSource(String args){
        super(args);
    }

    public NoFactoryDefinedForSource(String args,Exception e){
        super(args,e);
    }
}
