package com.study.transform.removefield;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

public class RemoveFieldVisitor extends ClassVisitor {
    private String fieldName;
    private String fieldDesc;
    public RemoveFieldVisitor(int api, ClassVisitor classVisitor, String fieldName, String fieldDesc) {
        super(api, classVisitor);
        this.fieldName = fieldName;
        this.fieldDesc = fieldDesc;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        if (name.equals(this.fieldName) && descriptor.equals(this.fieldDesc)) {
            return null;
        }
        return super.visitField(access, name, descriptor, signature, value);
    }
}
