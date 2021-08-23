package com.study;

public class HelloWorldRun {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassloader classloader = new MyClassloader();
        Class clazz = classloader.loadClass("HelloWorld");
        Object instance = clazz.newInstance();
        System.out.println(instance);
    }
}
