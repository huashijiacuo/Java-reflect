package com.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by shun on 2017/9/1.
 */
public class ReflectAttack {

    public static void main(String[] args) {
        ReflectAttack reflectAttack = new ReflectAttack();
        reflectAttack.attackSingleton3();
        System.out.println("********************************");
        reflectAttack.attackSingleton5();
        System.out.println("********************************");
        reflectAttack.attackModifierSingleton();
        System.out.println("********************************");
        reflectAttack.attackEnumSingleton();

    }

    public void attackSingleton5() {
        Class<?> singleton5Class = Singleton5.class;
        try {
            Constructor<?>[] constructors = singleton5Class.getDeclaredConstructors();
            constructors[0].setAccessible(true);
            Singleton5 instance1 = (Singleton5) constructors[0].newInstance();
            Singleton5 instance2 = (Singleton5) constructors[0].newInstance();
            if (instance1 == instance2) {
                System.out.println("attack failed,攻击Sinleton5失败");
            } else {
                System.out.println("attack success!攻击Sinleton5成功，创建了多个实例");
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void attackModifierSingleton() {
        Class<?> modifierSingletonClass = ModifierSingleton.class;
        try {
            Constructor<?> constructor = modifierSingletonClass.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            ModifierSingleton instance1 = (ModifierSingleton) constructor.newInstance();
            Field field = modifierSingletonClass.getDeclaredField("flag");
            field.setAccessible(true);
            field.setBoolean(ModifierSingleton.class, false);
            ModifierSingleton instance2 = (ModifierSingleton) constructor.newInstance();
            if (instance1 == instance2) {
                System.out.println("ModifierSingleton,attack failed");
            } else {
                System.out.println("ModifierSingleton, attack success!");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void attackEnumSingleton() {
        Class<?> enumClass =  Singleton6.class;
        Constructor<Singleton6> c = null;
        Singleton6 singleton6 = Singleton6.INSTANCE;
        try {
            //c = (Constructor<Singleton6>) enumClass.getDeclaredConstructor();
            //c.setAccessible(true);
            Singleton6 instance = (Singleton6) enumClass.newInstance();
            if (singleton6 == instance) {
                System.out.print("EnumSingleton attack success");
            } else {
                System.out.print("EnumSingleton attack failed");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    public void attackSingleton3() {
        Class<?> singleton3Class = Singleton3.class;
        try {
            Constructor<Singleton3> constructor = (Constructor<Singleton3>) singleton3Class.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Singleton3 instance1 = (Singleton3) constructor.newInstance();
            Singleton3 instance2 = Singleton3.getSingleton();
            if (instance1 != instance2) {
                System.out.println("攻击Singleton3成功，通过反射，创建了多个实例");
            } else {
                System.out.println("攻击Singleton3失败");
            }
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
