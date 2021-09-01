package com.study.utils;

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
        return 1;
    }

    public String toString() {
        System.out.println("Test");
        return "Test";
    }

    static class InnerHello {
        private int i = 1;
    }
    
    public byte[] toOracleStringWithReplacement(char[] paramArrayOfchar, int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int[] paramArrayOfint) {

        return null;
    }

}
