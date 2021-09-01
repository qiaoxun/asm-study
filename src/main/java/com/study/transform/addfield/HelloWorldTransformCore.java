package com.study.transform.addfield;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.objectweb.asm.Opcodes.ASM8;

public class HelloWorldTransformCore {
    public static void main(String[] args) throws IOException {
        HelloWorldAF helloWorldAF = new HelloWorldAF();
        String classFilePath = "C:/study/java/asm-study/target/classes/com/study/transform/addfield/HelloWorldAF.class";
        byte[] bytes = Files.readAllBytes(new File(classFilePath).toPath());

        ClassReader classReader = new ClassReader(bytes);

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        int api = ASM8;
        int parsingOptions = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;

        String addFieldName = "test";
        String addFieldDesc = "Ljava/lang/Object;";
        int addFieldAccess = Opcodes.ACC_PRIVATE + Opcodes.ACC_STATIC + Opcodes.ACC_FINAL;
        Object addFieldValue = "Test";

        ClassVisitor classVisitor = new AddFieldVisitor(api, classWriter, addFieldName, addFieldDesc, addFieldAccess, addFieldValue);

        classReader.accept(classVisitor, parsingOptions);

        byte[] bytes1 = classWriter.toByteArray();

        Files.write(new File("C:/study/java/asm-study/target/classes/com/study/transform/addfield/HelloWorldAF1.class").toPath(), bytes1);
    }
}
