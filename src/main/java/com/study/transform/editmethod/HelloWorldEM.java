package com.study.transform.editmethod;

import java.util.Date;

public class HelloWorldEM {

    public void sayHello() {
        System.out.println("Hello World");
    }

    public int testParameter(int i, int j, String name, Date date) {
        System.out.println("Hello World");
        return i + j;
    }

}
