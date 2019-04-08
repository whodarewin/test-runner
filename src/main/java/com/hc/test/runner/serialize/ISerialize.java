package com.hc.test.runner.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * 对于这个系统，只接受String类型的序列化，在系统边界内是没有问题的。
 * @param <T>
 */
public interface ISerialize<T> {
    String serialize(T t) throws JsonProcessingException;
    T deSerialize(String str) throws IOException;
}
