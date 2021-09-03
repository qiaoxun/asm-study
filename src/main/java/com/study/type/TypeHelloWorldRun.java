package com.study.type;

import org.junit.Test;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.util.Printer;

public class TypeHelloWorldRun {
    public static void main(String[] args) {
        Type type = Type.getType("Lorg.objectweb.asm.Type;");
        int sort = type.getSort();
        String className = type.getClassName();
        String internalName = type.getInternalName();
        String descriptor = type.getDescriptor();

        System.out.println(sort);
        System.out.println(className);
        System.out.println(internalName);
        System.out.println(descriptor);

        System.out.println(Type.VOID_TYPE.getSort());
    }

    @Test
    public void test1() {
        Type t = Type.DOUBLE_TYPE;
        int[] opcodes = new int[] {
                Opcodes.IALOAD,
                Opcodes.IASTORE,
                Opcodes.ILOAD,
                Opcodes.ISTORE,
                Opcodes.IADD,
                Opcodes.ISUB,
                Opcodes.IRETURN
        };

        for (int oldOpcode : opcodes) {
            int newOpcode = t.getOpcode(oldOpcode);
            String oldName = Printer.OPCODES[oldOpcode];
            String newName = Printer.OPCODES[newOpcode];
            System.out.println(oldOpcode);
            System.out.println(newOpcode);
            System.out.printf("%-7S --- %-7s%n", oldName, newName);
        }
    }
}





















