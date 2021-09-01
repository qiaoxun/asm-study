package com.study.classreader;

import org.objectweb.asm.ClassReader;

import java.io.IOException;

public class ClassReaderStudy {

    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader("com.study.utils.HelloWorld");
//        classReader.accept();
    }


}
