package com.singleton;

/**
 * Created by shun on 2017/9/1.
 */
public class Singleton4 {
    private static Singleton4 instance = null;
    static {
        instance = new Singleton4();
    }

    private Singleton4(){

    }

    public static Singleton4 getInstance(){
        return instance;
    }
}
