package com.study.classreader;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HelloWorldTransformCore {
    public static void main(String[] args) throws IOException {
        String classFilePath = "C:/study/java/asm-study/target/classes/com/study/utils/HelloWorld.class";
        byte[] bytes = Files.readAllBytes(new File(classFilePath).toPath());

        ClassReader classReader = new ClassReader(bytes);

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        int api = Opcodes.ASM8;
        int parsingOptions = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;

        classReader.accept(classWriter, parsingOptions);

        byte[] bytes1 = classWriter.toByteArray();

        Files.write(new File("C:/study/java/asm-study/target/classes/com/study/utils/HelloWorld1.class").toPath(), bytes1);
    }
}