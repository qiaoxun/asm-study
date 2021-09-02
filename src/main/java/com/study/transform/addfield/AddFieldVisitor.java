package com.study.transform.addfield;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

public class AddFieldVisitor extends ClassVisitor {
    private String fieldName;
    private String fieldDesc;
    private int fieldAccess;
    private Object fieldValue;
    private boolean isFieldPresent;

    public AddFieldVisitor(int api, ClassVisitor classVisitor, String fieldName, String fieldDesc, int fieldAccess, Object fieldValue) {
        super(api, classVisitor);
        this.fieldName = fieldName;
        this.fieldDesc = fieldDesc;
        this.fieldAccess = fieldAccess;
        this.fieldValue = fieldValue;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        if (name.equals(fieldName)) {
            isFieldPresent = true;
        }
        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public void visitEnd() {
        if (!isFieldPresent) {
            FieldVisitor fv = cv.visitField(fieldAccess, fieldName, fieldDesc, null, fieldValue);
            if (null != fv) {
                fv.visitEnd();
            }
        }
        super.visitEnd();
    }
}
