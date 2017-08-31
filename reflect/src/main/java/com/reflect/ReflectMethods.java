package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by shun on 2017/8/31.
 */
public class ReflectMethods {
    public static void main(String[] args) {
        Class<?> classType = Demo.class;
        Method[] methods = classType.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println();
        // 使用 getDeclaredMethods 获取函数
        methods = classType.getDeclaredMethods();

        for(Method m : methods) {
            System.out.println(m);
        }
        System.out.println();
        try {
            Method privateMethod = classType.getDeclaredMethod("testPrivateMethod", new Class[]{String.class});
            System.out.println(privateMethod);
            System.out.println();
            printParameterTypes(privateMethod);
            printReturnTypes(privateMethod);
            privateMethod.setAccessible(true);
            privateMethod.invoke(null, "meth-reflection");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Class[] printParameterTypes(Method method) {
        Class<?> [] paramTypes = method.getParameterTypes();
        for (Class<?> paramType : paramTypes) {
            System.out.println(paramType);
        }
        return paramTypes;
    }

    public static Class<?> printReturnTypes(Method method) {
        Class<?>  paramType = method.getReturnType();
        System.out.println(paramType);
        return paramType;
    }
}
