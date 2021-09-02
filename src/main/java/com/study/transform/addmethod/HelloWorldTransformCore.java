package com.study.transform.addmethod;

import com.study.transform.removefield.HelloWorldRF;
import com.study.transform.removefield.RemoveFieldVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.objectweb.asm.Opcodes.*;

public class HelloWorldTransformCore {
    public static void main(String[] args) throws IOException {
        HelloWorldAM helloWorldAM = new HelloWorldAM();
        String classFilePath = "C:/study/java/asm-study/target/classes/com/study/transform/addmethod/HelloWorldAM.class";
        byte[] bytes = Files.readAllBytes(new File(classFilePath).toPath());

        ClassReader classReader = new ClassReader(bytes);

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        int api = ASM8;
        int parsingOptions = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;

        ClassVisitor classVisitor = new AddMethodVisitor(api, classWriter, ACC_PUBLIC, "compareTo", "()I", null, null) {
            @Override
            public void generateClassBody(MethodVisitor methodVisitor) {
                methodVisitor.visitCode();
                methodVisitor.visitLdcInsn(1);
                methodVisitor.visitInsn(IRETURN);
                methodVisitor.visitMaxs(1, 1);
                methodVisitor.visitEnd();
            }
        };

        classReader.accept(classVisitor, parsingOptions);

        byte[] bytes1 = classWriter.toByteArray();

        Files.write(new File("C:/study/java/asm-study/target/classes/com/study/transform/addmethod/HelloWorldAM1.class").toPath(), bytes1);
    }
}
