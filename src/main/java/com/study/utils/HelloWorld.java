package com.study.utils;

import com.sun.org.apache.bcel.internal.generic.ISTORE;
import org.objectweb.asm.Opcodes;

@HelloAnnotation
public class HelloWorld<K> {

    private K k;

    public HelloWorld() {}

    public HelloWorld(String name) {
        System.out.println(name);
    }

    @HelloAnnotation
    public int compareTo(String a) throws Exception {
        int b = 1;
        System.out.println(b);
        if (a == null) {
            throw new RuntimeException();
        }
        return 1;
    }

    public Integer compareTo1() {
        int b = 1;
        return 1;
    }


    public static Integer compareTo2() {
        int b = 1;
        return 1;
    }

    public String toString() {
        System.out.println("Entering method");
        System.out.println("Entering method1");
        return "Test";
    }

    static class InnerHello {
        private int i = 1;
    }
    
    public byte[] toOracleStringWithReplacement(char[] paramArrayOfchar, int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int[] paramArrayOfint) {

        return null;
    }

}
