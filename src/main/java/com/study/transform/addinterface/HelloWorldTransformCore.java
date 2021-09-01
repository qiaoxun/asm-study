package com.study.transform.addinterface;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.objectweb.asm.Opcodes.ASM8;

public class HelloWorldTransformCore {
    public static void main(String[] args) throws IOException {
        String classFilePath = "C:/study/java/asm-study/target/classes/com/study/transform/addinterface/HelloWorldAI.class";
        byte[] bytes = Files.readAllBytes(new File(classFilePath).toPath());

        ClassReader classReader = new ClassReader(bytes);

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        int api = ASM8;
        int parsingOptions = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;

        ClassVisitor classVisitor = new AddInterfaceVisitor(api, classWriter);

        classReader.accept(classVisitor, parsingOptions);

        byte[] bytes1 = classWriter.toByteArray();

        Files.write(new File("C:/study/java/asm-study/target/classes/com/study/transform/addinterface/HelloWorldAI1.class").toPath(), bytes1);
    }
}
