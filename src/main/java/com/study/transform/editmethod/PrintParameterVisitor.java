package com.study.transform.editmethod;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
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
            mv = new PrintParameterMethodAdapter(api, mv, methodName, methodDescriptor);
        }
        return mv;
    }

    public static class PrintParameterMethodAdapter extends MethodVisitor {
        private String methodName;
        private String methodDescriptor;

        public PrintParameterMethodAdapter(int api, MethodVisitor mv, String methodName, String methodDescriptor) {
            super(api, mv);
            this.methodName = methodName;
            this.methodDescriptor = methodDescriptor;
        }

        @Override
        public void visitCode() {
            super.visitCode();
            Type[] types = Type.getArgumentTypes(this.methodDescriptor);
            for (Type type : types) {
                System.out.println(type.getSort());
                System.out.println(type.getClassName());
                System.out.println(type.getInternalName());
            }
        }
    }

}
