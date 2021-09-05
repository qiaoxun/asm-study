package com.study.transform.editmethod;

import com.study.transform.removefield.HelloWorldRF;
import com.study.transform.removefield.RemoveFieldVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.objectweb.asm.Opcodes.ASM8;

public class HelloWorldTransformCore {
    public static void main(String[] args) throws IOException {
        HelloWorldEM helloWorldEM = new HelloWorldEM();
        helloWorldEM.sayHello();
        String classFilePath = "C:/study/java/asm-study/target/classes/com/study/transform/editmethod/HelloWorldEM.class";
        byte[] bytes = Files.readAllBytes(new File(classFilePath).toPath());

        ClassReader classReader = new ClassReader(bytes);

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        int api = ASM8;
        int parsingOptions = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;

        String methodName = "testParameter";
        String methodDescriptor = "(IILjava/lang/String;Ljava/util/Date;)I";

//        ClassVisitor classVisitor = new EditMethodVisitor(api, classWriter, methodName);
        ClassVisitor classVisitor = new PrintParameterVisitor(api, classWriter, methodName, methodDescriptor);

        classReader.accept(classVisitor, parsingOptions);

        byte[] bytes1 = classWriter.toByteArray();

        Files.write(new File("C:/study/java/asm-study/target/classes/com/study/transform/editmethod/HelloWorldEM1.class").toPath(), bytes1);
    }
}
