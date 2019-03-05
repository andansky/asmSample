package com.example.lib;


import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

public class TracdMethod extends AdviceAdapter {

    private int timeLocalIndex;
    private String pathName;
    protected TracdMethod(String pathName, MethodVisitor mv, int access, String name, String desc) {
        super(Opcodes.ASM5, mv, access, name, desc);
        this.pathName=pathName;
    }


    @Override
    protected void onMethodEnter() {
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        timeLocalIndex=newLocal(Type.LONG_TYPE);
        mv.visitVarInsn(LSTORE, timeLocalIndex);
    }

    @Override
    protected void onMethodExit(int i) {
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitVarInsn(LLOAD,timeLocalIndex);
        mv.visitInsn(LSUB);
        mv.visitVarInsn(LSTORE,timeLocalIndex);
        mv.visitLdcInsn(pathName);//这个是不是传参数的意思
        mv.visitVarInsn(LLOAD,timeLocalIndex);
        mv.visitMethodInsn(INVOKESTATIC, "android/util/Log", "d", "(Ljava/lang/String;Ljava/lang/String;)I", false);
        mv.visitInsn(Opcodes.POP);
    }
}
