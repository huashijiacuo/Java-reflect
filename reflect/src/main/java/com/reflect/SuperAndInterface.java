package com.reflect;

import java.util.HashMap;

/**
 * Created by shun on 2017/8/31.
 */
public class SuperAndInterface {
    public static void main(String[] args) {
        Class<?> hashMapClass = HashMap.class;
        Class<?> [] interfaces = hashMapClass.getInterfaces();
        for (Class<?> interf : interfaces) {
            System.out.println(interf);
        }
        System.out.println();
        Class<?> superClass = hashMapClass.getSuperclass();
        System.out.println(superClass);
    }
}
