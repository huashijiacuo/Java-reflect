package com.singleton;

/**
 * Created by shun on 2017/9/1.
 * 懒汉模式，线程不安全
 */
public class Singleton1 {
    private static Singleton1 instance = null;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
