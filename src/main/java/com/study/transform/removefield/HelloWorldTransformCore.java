package com.study.transform.removefield;

import com.study.transform.changeversion.ClassChangeVersionVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.objectweb.asm.Opcodes.ASM8;

public class HelloWorldTransformCore {
    public static void main(String[] args) throws IOException {
        HelloWorldRF helloWorldRF = new HelloWorldRF();
        String classFilePath = "C:/study/java/asm-study/target/classes/com/study/transform/removefield/HelloWorldRF.class";
        byte[] bytes = Files.readAllBytes(new File(classFilePath).toPath());

        ClassReader classReader = new ClassReader(bytes);

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        int api = ASM8;
        int parsingOptions = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;

        String fieldName = "name";
        String fieldDesc = "Ljava/lang/String;";

        ClassVisitor classVisitor = new RemoveFieldVisitor(api, classWriter, fieldName, fieldDesc);

        classReader.accept(classVisitor, parsingOptions);

        byte[] bytes1 = classWriter.toByteArray();

        Files.write(new File("C:/study/java/asm-study/target/classes/com/study/transform/removefield/HelloWorldRF1.class").toPath(), bytes1);
    }
}
