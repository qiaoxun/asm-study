package com.study.transform.removemethod;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class RemoveMethodVisitor extends ClassVisitor {
    private String methodName;
    public RemoveMethodVisitor(int api, ClassVisitor classVisitor, String methodName) {
        super(api, classVisitor);
        this.methodName = methodName;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (this.methodName.equals(name)) {
            return null;
        }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }
}
