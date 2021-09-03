package com.study.transform.editmethod;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public abstract class EditMethodVisitor extends ClassVisitor {

    private String methodName;

    public EditMethodVisitor(int api, ClassVisitor classVisitor, String methodName) {
        super(api, classVisitor);
        this.methodName = methodName;
    }

    public abstract void editMethodBody(MethodVisitor methodVisitor);

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (methodName.equals(name)) {
            MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);
            editMethodBody(mv);
        }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

}
