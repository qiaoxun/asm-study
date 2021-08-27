package com.study.classvisitor;

import org.objectweb.asm.*;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM9;

public class ClassVisitorStudy {
    public static void main(String[] args) throws IOException {
        ClassPrinter cp = new ClassPrinter();
        ClassReader cr = new ClassReader("java.lang.Runnable");
        cr.accept(cp, 0);
    }
}

class ClassPrinter extends ClassVisitor {

    public ClassPrinter() {
        super(ASM9);
    }
    public void visit(
            final int version,
            final int access,
            final String name,
            final String signature,
            final String superName,
            final String[] interfaces) {
        System.out.println(name + " extends " + superName + " {");
    }

    public void visitSource(final String source, final String debug) {
    }

    public void visitOuterClass(String owner, String name, String desc) {
    }

    public AnnotationVisitor visitAnnotation(String desc,
                                             boolean visible) {
        return null;
    }

    public void visitAttribute(Attribute attr) {
    }

    public void visitInnerClass(String name, String outerName,
                                String innerName, int access) {
    }

    public FieldVisitor visitField(int access, String name, String desc,
                                   String signature, Object value) {
        System.out.println(" " + desc + " " + name);
        return null;
    }
    public MethodVisitor visitMethod(int access, String name,
                                     String desc, String signature, String[] exceptions) {
        System.out.println(" " + name + desc);
        return null;
    }
    public void visitEnd() {
        System.out.println("}");
    }


}