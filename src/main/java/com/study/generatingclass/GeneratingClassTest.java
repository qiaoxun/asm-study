package com.study.generatingclass;

import static org.objectweb.asm.Opcodes.*;

import com.study.utils.TestClassLoader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GeneratingClassTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT, "com/study/generatingclass/Comparable",
                null, "java/lang/Object", null);

        MethodVisitor mv1 = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv1.visitCode();
        mv1.visitVarInsn(ALOAD, 0);
        mv1.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv1.visitInsn(RETURN);
        mv1.visitMaxs(1, 1);
        mv1.visitEnd();

        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I", null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I", null, new Integer(0)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();

        byte[] bytes = cw.toByteArray();

        File file = new File("C:/study/note/study/Java/ASM/Comparable.class");
        Files.write(file.toPath(), bytes);

//        TestClassLoader testClassLoader = new TestClassLoader(bytes);
//        testClassLoader.loadClass("com.study.generatingclass.Comparable");
//        Class clazz = testClassLoader.loadClass("com.study.generatingclass.Comparable");
//        Object instance = clazz.newInstance();
//        System.out.println(instance);

    }
}

