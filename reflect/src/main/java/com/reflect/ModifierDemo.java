package com.reflect;

import java.lang.reflect.Modifier;

/**
 * Created by shun on 2017/8/31.
 */
public class ModifierDemo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Class<?> demoClass = demo.getClass();
        int modifiers = demoClass.getModifiers();
        printModifier(modifiers);

    }

    public static void printModifier(int modifiers) {
        System.out.println("modifiers = " + modifiers);
        System.out.println("isAbstract: " +Modifier.isAbstract(modifiers));
        System.out.println("isFinal: " + Modifier.isFinal(modifiers));
        System.out.println("isInterface: " + Modifier.isInterface(modifiers));
        System.out.println("isNative: " + Modifier.isNative(modifiers));
        System.out.println("isPrivate: " + Modifier.isPrivate(modifiers));
        System.out.println("isProtected: " + Modifier.isProtected(modifiers));
        System.out.println("isPublic: " + Modifier.isPublic(modifiers));
        System.out.println("isStatic: " + Modifier.isStatic(modifiers));
        System.out.println("isStrict: " + Modifier.isStrict(modifiers));
        System.out.println("isSynchronized: " + Modifier.isSynchronized(modifiers));
        System.out.println("isTransient: " + Modifier.isTransient(modifiers));
        System.out.println("isVolatile: " + Modifier.isVolatile(modifiers));
    }
}
