package com.reflect;

/**
 * Created by shun on 2017/8/31.
 */
public class Demo {
    public static void main(String[] args) {
        getFullName();
        getSimpleName();
    }

    public static void getFullName() {
        ReflectName reflectName = new ReflectName();
        System.out.println("FullName: " + reflectName.getClass().getName());
    }

    public static void getSimpleName() {
        ReflectName reflectName = new ReflectName();
        System.out.println("SimpleName: " + reflectName.getClass().getSimpleName());
    }

    private static void testPrivateMethod(String param) {
        System.out.print(param);
    }
}

class ReflectName {
    String name;
}
