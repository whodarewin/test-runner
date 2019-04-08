package com.hc.test.runner.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonSerialize<T> implements ISerialize<T> {
    private ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> clazz;

    public JsonSerialize(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String serialize(T t) throws JsonProcessingException {
        return objectMapper.writeValueAsString(t);
    }

    @Override
    public T deSerialize(String str) throws IOException {
        return objectMapper.readValue(str, clazz);
    }
}
