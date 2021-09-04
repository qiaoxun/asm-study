package com.study.transform.editmethod;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class EditMethodVisitor extends ClassVisitor {

    private String methodName;

    public EditMethodVisitor(int api, ClassVisitor classVisitor, String methodName) {
        super(api, classVisitor);
        this.methodName = methodName;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (methodName.equals(name)) {
            mv = new EditMethodAdapter(api, mv);
        }
        return mv;
    }


    public static class EditMethodAdapter extends MethodVisitor {

        public EditMethodAdapter(int api, MethodVisitor methodVisitor) {
            super(api, methodVisitor);
        }

        @Override
        public void visitCode() {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitLdcInsn("Entering method");
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            super.visitCode();
        }

        @Override
        public void visitInsn(int opcode) {
            super.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            super.visitLdcInsn("Exiting method");
            super.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            super.visitInsn(opcode);
        }
    }

}
