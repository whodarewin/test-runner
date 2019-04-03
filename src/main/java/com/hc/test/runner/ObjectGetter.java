package com.hc.test.runner;

/**
 * 从某一个地方获得或者创建一个需要的object
 */
public interface ObjectGetter<T> {
    T get(ConstructParam param);
}
