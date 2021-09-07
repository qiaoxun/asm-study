package com.study.transform.editmethod;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;
import org.objectweb.asm.Type;

public class PrintParameterVisitor extends ClassVisitor {

    private String methodName;
    private String methodDescriptor;

    public PrintParameterVisitor(int api, ClassVisitor cv, String methodName, String methodDescriptor) {
        super(api, cv);
        this.methodName = methodName;
        this.methodDescriptor = methodDescriptor;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (methodName.equals(name) && methodDescriptor.equals(descriptor)) {
            mv = new PrintParameterMethodAdapter(api, mv, methodName, methodDescriptor, access);
        }
        return mv;
    }

    public static class PrintParameterMethodAdapter extends MethodVisitor {
        private String methodName;
        private String methodDescriptor;
        private int methodAccess;

        public PrintParameterMethodAdapter(int api, MethodVisitor mv, String methodName, String methodDescriptor, int methodAccess) {
            super(api, mv);
            this.methodName = methodName;
            this.methodDescriptor = methodDescriptor;
            this.methodAccess = methodAccess;
        }

        @Override
        public void visitCode() {
            super.visitCode();
            boolean isStatic = (this.methodAccess & ACC_STATIC) != 0;
            int slotIndex = isStatic ? 0 : 1;

            Type[] types = Type.getArgumentTypes(this.methodDescriptor);
            for (Type type : types) {
                int sort = type.getSort();
                int size = type.getSize();
                String descriptor = type.getDescriptor();
                int opcodes = type.getOpcode(ILOAD);
                super.visitVarInsn(opcodes, slotIndex);

                System.out.println(type.getSort());
                System.out.println(type.getClassName());
                System.out.println(type.getInternalName());
                System.out.println(type.getSize());
            }
        }
    }

}
