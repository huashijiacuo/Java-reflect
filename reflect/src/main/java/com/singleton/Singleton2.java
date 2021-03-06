package com.singleton;

/**
 * Created by shun on 2017/9/1.
 * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，
 * 但是，遗憾的是，效率很低，99%情况下不需要同步。
 */
public class Singleton2 {
    private static Singleton2 instance  = null;
    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {
        if (instance  == null) {
            instance  = new Singleton2();
        }
        return instance ;
    }
}
