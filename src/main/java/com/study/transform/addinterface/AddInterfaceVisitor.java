package com.study.transform.addinterface;

import org.objectweb.asm.ClassVisitor;

public class AddInterfaceVisitor extends ClassVisitor {
    public AddInterfaceVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, new String[]{"java/lang/Cloneable"});
    }
}
