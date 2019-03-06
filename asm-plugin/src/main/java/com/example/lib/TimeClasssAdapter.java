package com.example.lib;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;


public class TimeClasssAdapter extends ClassVisitor {
    private String className;
    public TimeClasssAdapter(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className=name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv=cv.visitMethod(access, name, descriptor, signature, exceptions);
        return mv==null?null:new TracdMethod(className + File.separator + name, mv, access, name, descriptor) ;
    }
}
