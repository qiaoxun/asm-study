package com.study.transform.addmethod;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public abstract class AddMethodVisitor extends ClassVisitor {
    private int methodAccess;
    private String methodName;
    private String methodDescriptor;
    private String methodSignature;
    private String[] methodExceptions;

    public AddMethodVisitor(int api, ClassVisitor classVisitor, int methodAccess, String methodName, String methodDescriptor, String methodSignature, String[] methodExceptions) {
        super(api, classVisitor);
        this.methodAccess = methodAccess;
        this.methodName = methodName;
        this.methodDescriptor = methodDescriptor;
        this.methodSignature = methodSignature;
        this.methodExceptions = methodExceptions;
    }

    public abstract void generateClassBody(MethodVisitor methodVisitor);

    @Override
    public void visitEnd() {
        MethodVisitor methodVisitor = cv.visitMethod(methodAccess, methodName, methodDescriptor, methodSignature, methodExceptions);
        generateClassBody(methodVisitor);
        super.visitEnd();
    }
}
