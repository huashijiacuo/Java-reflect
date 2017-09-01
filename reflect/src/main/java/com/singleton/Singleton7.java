package com.singleton;

/**
 * Created by shun on 2017/9/1.
 * 第二种方式的升级版，俗称双重检查锁定
 */
public class Singleton7 {
    private volatile  Singleton7 instance = null;

    private Singleton7() {

    }

    public Singleton7 getInstance() {
        if (instance == null) {
            synchronized (Singleton7.class) {
                if (instance == null) {
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }
}
