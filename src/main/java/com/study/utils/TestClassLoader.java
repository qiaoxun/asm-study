package com.study.utils;

public class TestClassLoader extends ClassLoader {

    private byte[] bytes;

    public TestClassLoader(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    protected Class<?> findClass(String name) {
        Class<?> clazz = defineClass(name, bytes, 0, bytes.length);
        return clazz;
    }
}
