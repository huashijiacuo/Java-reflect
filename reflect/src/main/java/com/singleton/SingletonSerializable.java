package com.singleton;

import java.io.Serializable;

/**
 * Created by shun on 2017/9/1.
 * 如果Singleton实现了java.io.Serializable接口，
 * 那么这个类的实例就可能被序列化和复原。不管怎样，
 * 如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。
 *(该方式可以修复，有待实践）
 */
public class SingletonSerializable implements Serializable {
    public static SingletonSerializable INSTANCE = new SingletonSerializable();
    protected SingletonSerializable(){

    }

    private Object readResolve() {
        return INSTANCE;
    }
}
