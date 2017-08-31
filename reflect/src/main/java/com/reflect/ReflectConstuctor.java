package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shun on 2017/8/31.
 */
public class ReflectConstuctor {
    public static void main(String[] args) {
        Class<?> hashMapClassClass = HashMap.class;
        Constructor<?>[] constructors = hashMapClassClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        try {
            Constructor<?> constructor = hashMapClassClass.getConstructor(null);
            Map map = (HashMap)constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
