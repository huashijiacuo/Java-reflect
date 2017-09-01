package com.singleton;

/**
 * Created by shun on 2017/9/1.
 */
public class ModifierSingleton {
    private static boolean flag = false;
    private ModifierSingleton(){
        synchronized (ModifierSingleton.class) {
            if (flag == false) {
                flag = !flag;
            } else {
                System.out.println("ModifierSingleton is attacked");
                throw new RuntimeException("单例模式被攻击");
            }
        }
    }

    private static class SingletonInstance {
        private static final ModifierSingleton INSTANCE = new ModifierSingleton();
    }

    public ModifierSingleton getInstance() {
        return ModifierSingleton.SingletonInstance.INSTANCE;
    }
}
