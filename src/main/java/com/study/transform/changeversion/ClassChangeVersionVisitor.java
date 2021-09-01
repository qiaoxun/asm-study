package com.study.transform.changeversion;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

public class ClassChangeVersionVisitor extends ClassVisitor {
    public ClassChangeVersionVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        // 修改类的版本为 7
        super.visit(Opcodes.V1_7, access, name, signature, superName, interfaces);
    }
}
